package com.newcoder.huaweiexam.hard;

import java.util.Scanner;

/**
 * 描述
 * 子网掩码是用来判断任意两台计算机的IP地址是否属于同一子网络的根据。
 * 子网掩码与IP地址结构相同，是32位二进制数，其中网络号部分全为“1”和主机号部分全为“0”。利用子网掩码可以判断两台主机是否中同一子网中。若两台主机的IP地址分别与它们的子网掩码相“与”后的结果相同，则说明这两台主机在同一子网中。
 *
 * 示例：
 * I P 地址　 192.168.0.1
 * 子网掩码　 255.255.255.0
 *
 * 转化为二进制进行运算：
 *
 * I P 地址　  11000000.10101000.00000000.00000001
 * 子网掩码　11111111.11111111.11111111.00000000
 *
 * AND运算   11000000.10101000.00000000.00000000
 *
 * 转化为十进制后为：
 * 192.168.0.0
 *
 *
 * I P 地址　 192.168.0.254
 * 子网掩码　 255.255.255.0
 *
 *
 * 转化为二进制进行运算：
 *
 * I P 地址　11000000.10101000.00000000.11111110
 * 子网掩码  11111111.11111111.11111111.00000000
 *
 * AND运算  11000000.10101000.00000000.00000000
 *
 * 转化为十进制后为：
 * 192.168.0.0
 *
 * 通过以上对两台计算机IP地址与子网掩码的AND运算后，我们可以看到它运算结果是一样的。均为192.168.0.0，所以这二台计算机可视为是同一子网络。
 *
 * 输入一个子网掩码以及两个ip地址，判断这两个ip地址是否是一个子网络。
 * 若IP地址或子网掩码格式非法则输出1，若IP1与IP2属于同一子网络输出0，若IP1与IP2不属于同一子网络输出2。
 *
 * 注:
 * 有效掩码与IP的性质为：
 * 1. 掩码与IP每一段在 0 - 255 之间
 * 2. 掩码的二进制字符串前缀为网络号，都由‘1’组成；后缀为主机号，都由'0'组成
 *
 * 本题有多组输入
 *
 * 输入描述：
 * 多组输入，一组3行，第1行是输入子网掩码、第2，3行是输入两个ip地址
 *
 * 输出描述：
 * 若IP地址或子网掩码格式非法则输出1，若IP1与IP2属于同一子网络输出0，若IP1与IP2不属于同一子网络输出2
 *
 * 示例1
 * 输入：
 * 255.255.255.0
 * 192.168.224.256
 * 192.168.10.4
 * 255.0.0.0
 * 193.194.202.15
 * 232.43.7.59
 * 255.255.255.0
 * 192.168.0.254
 * 192.168.0.1
 * 复制
 * 输出：
 * 1
 * 2
 * 0
 * 复制
 * 说明：
 * 对于第一个例子:
 * 255.255.255.0
 * 192.168.224.256
 * 192.168.10.4
 * 其中IP:192.168.224.256不合法，输出1
 *
 * 对于第二个例子:
 * 255.0.0.0
 * 193.194.202.15
 * 232.43.7.59
 * 2个与运算之后，不在同一个子网，输出2
 *
 * 对于第三个例子，2个与运算之后，如题目描述所示，在同一个子网，输出0
 */
public class CheckIfTwoIPAddressesInSameSubnet {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String subnetMask = in.nextLine();
            String ip1 = in.nextLine();
            String ip2 = in.nextLine();
            
            int flag = checkIfTwoIPAddressesInSameSubnet(subnetMask, ip1, ip2);

            System.out.println(flag);
        }
    }

    private static int checkIfTwoIPAddressesInSameSubnet(String subnetMask, String ip1, String ip2) {
        if (!isValidSubnet(subnetMask) || !isValidIP(ip1) || !isValidIP(ip2)) {
            return 1;
        }

        String[] subnetMaskArr = subnetMask.split("\\.");
        String[] subnetMaskBinaryArr = convertDecimalElementToBinary(subnetMaskArr);

        String[] ip1Arr = ip1.split("\\.");
        String[] ip1BinaryArr = convertDecimalElementToBinary(ip1Arr);

        String[] ip2Arr = ip2.split("\\.");
        String[] ip2BinaryArr = convertDecimalElementToBinary(ip2Arr);

        String[] ip1AndSubnetMaskBinaryArr = bitwiseAnd(ip1BinaryArr, subnetMaskBinaryArr);
        String[] ip2AndSubnetMaskBinaryArr = bitwiseAnd(ip2BinaryArr, subnetMaskBinaryArr);

        String[] ip1AndSubnetMaskDecimalArr = convertBinaryElementToDecimal(ip1AndSubnetMaskBinaryArr);
        String[] ip2AndSubnetMaskDecimalArr = convertBinaryElementToDecimal(ip2AndSubnetMaskBinaryArr);

        for (int i = 0; i < ip1AndSubnetMaskDecimalArr.length; i++) {
            if (!ip1AndSubnetMaskDecimalArr[i].equals(ip2AndSubnetMaskDecimalArr[i])) {
                return 2;
            }
        }

        return 0;
    }

    private static String[] convertBinaryElementToDecimal(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(Integer.parseInt(arr[i], 2));
        }
        return arr;
    }

    private static String[] bitwiseAnd(String[] strArr1, String[] strArr2) {
        String[] arr = new String[strArr1.length];

        for (int i = 0; i < strArr1.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < strArr1[i].length(); j++) {
                sb.append(Character.getNumericValue(strArr1[i].charAt(j)) & Character.getNumericValue(strArr2[i].charAt(j)));
            }
            arr[i] = sb.toString();
        }

        return arr;
    }

    private static String[] convertDecimalElementToBinary(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            StringBuilder sb = new StringBuilder();

            String binaryStr = Integer.toBinaryString(Integer.parseInt(strArr[i]));
            if (binaryStr.length() < 8) {
                for (int j = 0; j < 8 - binaryStr.length(); j++) {
                    sb.append("0");
                }
            }
            sb.append(binaryStr);
            binaryStr = sb.toString();
            strArr[i] = binaryStr;
        }

        return strArr;
    }

    // it is tricky to check the validity of subnet
    private static boolean isValidSubnet(String str) {
        if (!isValidIP(str)) {
            return false;
        }

        String[] strArr = str.split("\\.");
        String[] binaryArr = convertDecimalElementToBinary(strArr);

        StringBuilder sb = new StringBuilder();
        for (String s : binaryArr) {
            sb.append(s);
        }

        return !sb.toString().contains("01");
    }

    private static boolean isValidIP(String str) {
        String[] strArr = str.split("\\.");
        if (strArr.length != 4) {
            return false;
        }

        for (String s : strArr) {
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i))) {
                    return false;
                }
            }

            if (Integer.parseInt(s) > 255) {
                return false;
            }
        }

        return true;
    }
}
