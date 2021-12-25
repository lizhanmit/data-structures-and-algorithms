package com.newcoder.huaweiexam.veryhard;

import java.util.Scanner;

/**
 * 描述
 * 请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。
 *
 * 所有的IP地址划分为 A,B,C,D,E五类
 *
 * A类地址1.0.0.0~126.255.255.255;
 *
 * B类地址128.0.0.0~191.255.255.255;
 *
 * C类地址192.0.0.0~223.255.255.255;
 *
 * D类地址224.0.0.0~239.255.255.255；
 *
 * E类地址240.0.0.0~255.255.255.255
 *
 *
 * 私网IP范围是：
 *
 * 10.0.0.0-10.255.255.255
 *
 * 172.16.0.0-172.31.255.255
 *
 * 192.168.0.0-192.168.255.255
 *
 *
 * 子网掩码为二进制下前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
 * （注意二进制下全是1或者全是0均为非法子网掩码）
 *
 * 注意：
 * 1. 类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时请忽略
 * 2. 私有IP地址和A,B,C,D,E类地址是不冲突的
 *
 * 输入描述：
 * 多行字符串。每行一个IP地址和掩码，用~隔开。
 *
 * 输出描述：
 * 统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。
 *
 * 示例1
 * 输入：
 * 10.70.44.68~255.254.255.0
 * 1.0.0.1~255.0.0.0
 * 192.168.0.2~255.255.255.0
 * 19..0.~255.255.255.0
 * 复制
 * 输出：
 * 1 0 1 0 0 2 1
 * 复制
 * 说明：
 * 10.70.44.68~255.254.255.0的子网掩码非法，19..0.~255.255.255.0的IP地址非法，所以错误IP地址或错误掩码的计数为2；
 * 1.0.0.1~255.0.0.0是无误的A类地址；
 * 192.168.0.2~255.255.255.0是无误的C类地址且是私有IP；
 * 所以最终的结果为1 0 1 0 0 2 1
 * 示例2
 * 输入：
 * 0.201.56.50~255.255.111.255
 * 127.201.56.50~255.255.111.255
 * 复制
 * 输出：
 * 0 0 0 0 0 0 0
 * 复制
 * 说明：
 * 类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时请忽略
 */
public class CategorizeAndCountValidIPAddressAndSubnet {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int countOfA = 0;
        int countOfB = 0;
        int countOfC = 0;
        int countOfD = 0;
        int countOfE = 0;
        int countOfError = 0;
        int countOfPrivate = 0;

        while (in.hasNextLine()) {
            String[] strArr = in.nextLine().split("~");
            String ipAddress = strArr[0];
            String subnetAddress = strArr[1];

            IP ip = new IP(ipAddress);
            Subnet subnet = new Subnet(subnetAddress);

            if(ip.isException()) {
                continue;
            } else if (!ip.isValid() || !subnet.isValid()) {
                countOfError++;
            } else {
                switch (ip.getCategory()) {
                    case 'A': countOfA++; break;
                    case 'B': countOfB++; break;
                    case 'C': countOfC++; break;
                    case 'D': countOfD++; break;
                    case 'E': countOfE++; break;
                    default: break;
                }

                if (ip.isPrivate()) {
                    countOfPrivate++;
                }
            }
        }

        System.out.println(countOfA + " " + countOfB + " " + countOfC + " " + countOfD + " " + countOfE + " " + countOfError + " " + countOfPrivate);
    }
}

class IP {
    private boolean isValid;
    private boolean isPrivate;
    private boolean isException;
    private char category;
    private String value;

    public IP(String value) {
        this.value = value;
        String[] valueArr = value.split("\\.");
        setIsValid(valueArr);
        setIsPrivate(valueArr);
        setIsException(valueArr);
        setCategory(valueArr);
    }

    private void setIsValid(String[] valueArr) {
        if (valueArr.length != 4) {
            this.isValid = false;
            return;
        }

        for (String s : valueArr) {
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i))) {
                    this.isValid = false;
                    return;
                }
            }

            if (Integer.parseInt(s) > 255 || Integer.parseInt(s) < 0) {
                this.isValid = false;
                return;
            }
        }

        this.isValid = true;
    }

    private void setIsException(String[] valueArr) {
        this.isException = valueArr[0].equals("0") || valueArr[0].equals("127");
    }

    private void setIsPrivate(String[] valueArr) {
        if (!isValid) {
            return;
        }

        if ((Integer.parseInt(valueArr[0]) == 10 && Integer.parseInt(valueArr[1]) >= 0 && Integer.parseInt(valueArr[1]) <= 255 && Integer.parseInt(valueArr[2]) >= 0 && Integer.parseInt(valueArr[2]) <= 255 && Integer.parseInt(valueArr[3]) >= 0 && Integer.parseInt(valueArr[3]) <= 255) ||
                (Integer.parseInt(valueArr[0]) == 172 && Integer.parseInt(valueArr[1]) >= 16 && Integer.parseInt(valueArr[1]) <= 31 && Integer.parseInt(valueArr[2]) >= 0 && Integer.parseInt(valueArr[2]) <= 255 && Integer.parseInt(valueArr[3]) >= 0 && Integer.parseInt(valueArr[3]) <= 255) ||
                (Integer.parseInt(valueArr[0]) == 192 && Integer.parseInt(valueArr[1]) == 168 && Integer.parseInt(valueArr[2]) >= 0 && Integer.parseInt(valueArr[2]) <= 255 && Integer.parseInt(valueArr[3]) >= 0 && Integer.parseInt(valueArr[3]) <= 255)
        ) {
            this.isPrivate = true;
            return;
        }

        this.isPrivate = false;
    }

    private void setCategory(String[] valueArr) {
        if (!isValid) {
            return;
        }

        if (Integer.parseInt(valueArr[0]) >= 1 && Integer.parseInt(valueArr[0]) <= 126 && Integer.parseInt(valueArr[1]) >= 0 && Integer.parseInt(valueArr[1]) <= 255 && Integer.parseInt(valueArr[2]) >= 0 && Integer.parseInt(valueArr[2]) <= 255 && Integer.parseInt(valueArr[3]) >= 0 && Integer.parseInt(valueArr[3]) <= 255) {
            this.category = 'A';
        } else if (Integer.parseInt(valueArr[0]) >= 128 && Integer.parseInt(valueArr[0]) <= 191 && Integer.parseInt(valueArr[1]) >= 0 && Integer.parseInt(valueArr[1]) <= 255 && Integer.parseInt(valueArr[2]) >= 0 && Integer.parseInt(valueArr[2]) <= 255 && Integer.parseInt(valueArr[3]) >= 0 && Integer.parseInt(valueArr[3]) <= 255) {
            this.category = 'B';
        } else if (Integer.parseInt(valueArr[0]) >= 192 && Integer.parseInt(valueArr[0]) <= 223 && Integer.parseInt(valueArr[1]) >= 0 && Integer.parseInt(valueArr[1]) <= 255 && Integer.parseInt(valueArr[2]) >= 0 && Integer.parseInt(valueArr[2]) <= 255 && Integer.parseInt(valueArr[3]) >= 0 && Integer.parseInt(valueArr[3]) <= 255) {
            this.category = 'C';
        } else if (Integer.parseInt(valueArr[0]) >= 224 && Integer.parseInt(valueArr[0]) <= 239 && Integer.parseInt(valueArr[1]) >= 0 && Integer.parseInt(valueArr[1]) <= 255 && Integer.parseInt(valueArr[2]) >= 0 && Integer.parseInt(valueArr[2]) <= 255 && Integer.parseInt(valueArr[3]) >= 0 && Integer.parseInt(valueArr[3]) <= 255) {
            this.category = 'D';
        } else if (Integer.parseInt(valueArr[0]) >= 240 && Integer.parseInt(valueArr[0]) <= 255 && Integer.parseInt(valueArr[1]) >= 0 && Integer.parseInt(valueArr[1]) <= 255 && Integer.parseInt(valueArr[2]) >= 0 && Integer.parseInt(valueArr[2]) <= 255 && Integer.parseInt(valueArr[3]) >= 0 && Integer.parseInt(valueArr[3]) <= 255) {
            this.category = 'E';
        }
    }

    public boolean isValid() {
        return isValid;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public boolean isException() {
        return isException;
    }

    public char getCategory() {
        return category;
    }
}

class Subnet {
    private boolean isValid;
    private String value;

    public Subnet(String value) {
        this.value = value;
        String[] valueArr = value.split("\\.");
        setIsValid(valueArr);
    }

    private void setIsValid(String[] valueArr) {
        if (valueArr.length != 4) {
            this.isValid = false;
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (String s : valueArr) {
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i))) {
                    this.isValid = false;
                    return;
                }
            }

            if (Integer.parseInt(s) > 255 || Integer.parseInt(s) < 0) {
                this.isValid = false;
                return;
            }

            StringBuilder tempSb = new StringBuilder();
            String binaryStr = Integer.toBinaryString(Integer.parseInt(s));
            if (binaryStr.length() < 8) {
                for (int j = 0; j < 8 - binaryStr.length(); j++) {
                    tempSb.append("0");
                }
            }
            tempSb.append(binaryStr);
            binaryStr = tempSb.toString();
            sb.append(binaryStr);
        }

        String str = sb.toString();
        if (!str.contains("1") || !str.contains("0") || str.contains("01")) {
            this.isValid = false;
        } else {
            this.isValid = true;
        }
    }

    public boolean isValid() {
        return isValid;
    }
}