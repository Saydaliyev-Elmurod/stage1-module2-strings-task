package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     * 1. access modifier - optional, followed by space: ' '
     * 2. return type - followed by space: ' '
     * 3. method name
     * 4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     * accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     * private void log(String value)
     * Vector3 distort(int x, int y, int z, float magnitude)
     * public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        String[] arr = signatureString.split(" ");
        String second = arr[2];
        if (arr[1].contains("(")) {
            second = arr[1];
        }
        String methodName = second.substring(0, second.indexOf("("));
        MethodSignature methodSignature = getMethodSignature(signatureString, methodName);
        methodSignature.setAccessModifier(arr[0]);
        methodSignature.setReturnType(arr[1]);
        return methodSignature;
    }

    private static MethodSignature getMethodSignature(String signatureString, String methodName) {
        List<MethodSignature.Argument> arguments = new ArrayList<>();
        String argument = signatureString.substring(signatureString.indexOf("(") + 1, signatureString.indexOf(")"));
        String[] args = argument.split(", ");
        for (String arg : args) {
            String[] subArgs = arg.split(" ");
            MethodSignature.Argument argument1 = new MethodSignature.Argument(subArgs[0], subArgs[1]);
            arguments.add(argument1);
        }
        return new MethodSignature(methodName, arguments);
    }
}
