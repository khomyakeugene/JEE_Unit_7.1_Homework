package com.company.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Yevhen on 08.06.2016.
 */
public class ObjectService {
    private static final String GET_PREFIX = "get";
    private static final String SET_PREFIX = "set";

    private static String[] getPublicMethodNameList(Object object, String methodPrefix) {
        Method[] methods = object.getClass().getMethods();
        ArrayList<String> nameArrayList = new ArrayList<>();

        boolean notPrefixCheck = (methodPrefix == null) || methodPrefix.isEmpty();
        for (Method method : methods) {
            String name = method.getName();
            if (notPrefixCheck || name.indexOf(methodPrefix) == 0) {
                nameArrayList.add(name);
            }
        }

        String[] methodNameList = new String[nameArrayList.size()];
        nameArrayList.toArray(methodNameList);

        return methodNameList;
    }

    private static String[] getGettersNameList(Object object) {
        return getPublicMethodNameList(object, GET_PREFIX);
    }

    private static String[] getSettersNameList(Object object) {
        return getPublicMethodNameList(object, SET_PREFIX);
    }

    private static Method searchMethod(String className, String methodName, Class<?>[] parameterTypes, boolean onlyPublic) {
        Method method = null;
        if (methodName != null) {
            try {
                Class<?> cls = Class.forName(className);

                try {
                    method = onlyPublic ? cls.getMethod(methodName, parameterTypes) :
                            cls.getDeclaredMethod(methodName, parameterTypes);
                    if (method != null) {
                        method.setAccessible(true);
                    }
                } catch (NullPointerException | SecurityException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            } catch (NullPointerException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return method;
    }

    private static Method searchMethod(Object object, String methodName, Class[] parameterTypes, boolean onlyPublic) {
        return searchMethod(object.getClass().getName(), methodName, parameterTypes, onlyPublic);
    }

    private static Method searchPublicMethod(Object object, String methodName, Class[] parameterTypes) {
        return searchMethod(object, methodName, parameterTypes, true);
    }

    private static Method searchPublicMethodWithoutParameters(Object object, String methodName) {
        return searchPublicMethod(object, methodName, new Class[]{});
    }

    private static Object invokeMethod(Object object, Method method, Object... args) {
        try {
            return method.invoke(object, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static Object invokePublicEmptyArgumentMethod(Object object, String methodName) {
        return invokeMethod(object, searchPublicMethodWithoutParameters(object, methodName));
    }

    public static boolean isEqualByGetterValuesStringRepresentation(Object object1, Object object2) {
        boolean result = object1.getClass().equals(object2.getClass());

        if (result) {
            for (String s : getGettersNameList(object1)) {
                Object methodResult1 = invokePublicEmptyArgumentMethod(object1, s);
                Object methodResult2 = invokePublicEmptyArgumentMethod(object2, s);

                result = ((methodResult1 == null) ? "" : methodResult1.toString()).
                        equals((methodResult2 == null) ? "" : methodResult2.toString());
                if (!result) {
                    break;
                }
            }
        }

        return result;
    }

    public static Object copyObjectByAccessors(Object source, Object target) {
        if (source != null && target != null) {
            String[] sourceGetters = getGettersNameList(source);
            String[] targetSetters = getSettersNameList(target);

            Arrays.stream(sourceGetters).forEach(getter -> {
                String setterName = SET_PREFIX + getter.substring(GET_PREFIX.length());
                if (Arrays.stream(targetSetters).filter(s -> s.equals(setterName)).findFirst().isPresent()) {
                    try {
                        Method getterMethod = source.getClass().getMethod(getter);
                        Class returnType = getterMethod.getReturnType();
                        try {
                            Method setterMethod = target.getClass().getMethod(setterName, returnType);
                            if (setterMethod != null) {
                                try {
                                    setterMethod.invoke(target, getterMethod.invoke(source));
                                } catch (IllegalAccessException | InvocationTargetException e) {
                                    // Theoretically, such exception should not be raised and caught here
                                    throw new RuntimeException(e);
                                }
                            }
                        } catch (NoSuchMethodException e) {
                            // Not all "analogs" of source.getters should be presented as target.setters

                        }
                    } catch (NoSuchMethodException e) {
                        // Theoretically, such exception should not be raised and caught here
                        throw new RuntimeException(e);
                    }
                }
            });
        }

        return target;
    }
}
