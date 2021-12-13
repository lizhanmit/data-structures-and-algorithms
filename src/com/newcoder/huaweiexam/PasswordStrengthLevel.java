package com.newcoder.huaweiexam;

import java.util.Scanner;

/**
 * 描述
 * 密码按如下规则进行计分，并根据不同的得分为密码进行安全等级划分。
 *
 * 一、密码长度:
 *
 * 5 分: 小于等于4 个字符
 *
 * 10 分: 5 到7 字符
 *
 * 25 分: 大于等于8 个字符
 *
 * 二、字母:
 *
 * 0 分: 没有字母
 *
 * 10 分: 全都是小（大）写字母
 *
 * 20 分: 大小写混合字母
 *
 * 三、数字:
 *
 * 0 分: 没有数字
 *
 * 10 分: 1 个数字
 *
 * 20 分: 大于1 个数字
 *
 * 四、符号:
 *
 * 0 分: 没有符号
 *
 * 10 分: 1 个符号
 *
 * 25 分: 大于1 个符号
 *
 * 五、奖励:
 *
 * 2 分: 字母和数字
 *
 * 3 分: 字母、数字和符号
 *
 * 5 分: 大小写字母、数字和符号
 *
 * 最后的评分标准:
 *
 * >= 90: 非常安全
 *
 * >= 80: 安全（Secure）
 *
 * >= 70: 非常强
 *
 * >= 60: 强（Strong）
 *
 * >= 50: 一般（Average）
 *
 * >= 25: 弱（Weak）
 *
 * >= 0:  非常弱
 *
 *
 * 对应输出为：
 *
 * VERY_SECURE
 *
 * SECURE
 *
 * VERY_STRONG
 *
 * STRONG
 *
 * AVERAGE
 *
 * WEAK
 *
 * VERY_WEAK
 *
 *
 * 请根据输入的密码字符串，进行安全评定。
 *
 * 注：
 *
 * 字母：a-z, A-Z
 *
 * 数字：0-9
 *
 * 符号包含如下： (ASCII码表可以在UltraEdit的菜单view->ASCII Table查看)
 *
 * !"#$%&'()*+,-./     (ASCII码：0x21~0x2F)
 *
 * :;<=>?@             (ASCII码：0x3A~0x40)
 *
 * [\]^_`              (ASCII码：0x5B~0x60)
 *
 * {|}~                (ASCII码：0x7B~0x7E)
 *
 *
 *
 *
 * 提示:
 * 1 <= 字符串的长度<= 300
 * 输入描述：
 * 本题含有多组输入样例。
 * 每组样例输入一个string的密码
 *
 * 输出描述：
 * 每组样例输出密码等级
 */
public class PasswordStrengthLevel {

    private static final String VERY_SECURE = "VERY_SECURE";
    private static final String SECURE = "SECURE";
    private static final String VERY_STRONG = "VERY_STRONG";
    private static final String STRONG = "STRONG";
    private static final String AVERAGE = "AVERAGE";
    private static final String WEAK = "WEAK";
    private static final String VERY_WEAK = "VERY_WEAK";

    private String password;
    private int numOfUpperLetter = 0;
    private int numOfLowerLetter = 0;
    private int numOfDigit = 0;
    private int numOfSign = 0;
    private int scoreByPasswordLength =  0;
    private int scoreByLetter = 0;
    private int scoreByDigit = 0;
    private int scoreBySign = 0;
    private int scoreByBonus = 0;
    private int sumScore = 0;
    private String strengthLevel;

    public PasswordStrengthLevel(String password) {
        this.password = password;

        char[] charArr = password.toCharArray();

        // iterate char array, and check each character
        for (char c: charArr) {
            if (isUpperLetter(c)) {
                this.numOfUpperLetter++;
            } else if (isLowerLetter(c)) {
                this.numOfLowerLetter++;
            } else if (isDigit(c)) {
                this.numOfDigit++;
            } else {
                this.numOfSign++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String input = in.nextLine();

            PasswordStrengthLevel pwdStrengthLevel = new PasswordStrengthLevel(input);
            pwdStrengthLevel.calStrengthLevel();
            String strengthLevel = pwdStrengthLevel.getStrengthLevel();

            System.out.println(strengthLevel);
        }
    }

    private void calStrengthLevel() {
        this.calScoreByPasswordLength();
        this.calScoreByLetter();
        this.calScoreByDigit();
        this.calScoreBySign();
        this.calScoreByBonus();
        this.calSumScore();

        if (this.sumScore >= 90) {
            this.setStrengthLevel(VERY_SECURE);
        } else if (this.sumScore >= 80) {
            this.setStrengthLevel(SECURE);
        } else if (this.sumScore >= 70) {
            this.setStrengthLevel(VERY_STRONG);
        } else if (this.sumScore >= 60) {
            this.setStrengthLevel(STRONG);
        } else if (this.sumScore >= 50) {
            this.setStrengthLevel(AVERAGE);
        } else if (this.sumScore >= 25) {
            this.setStrengthLevel(WEAK);
        } else {
            this.setStrengthLevel(VERY_WEAK);
        }
    }

    private void calSumScore() {
        this.setSumScore(this.scoreByPasswordLength + this.scoreByLetter + this.scoreByDigit + this.scoreBySign + this.scoreByBonus);
    }

    private void calScoreByBonus() {
        if (this.numOfUpperLetter > 0 && this.numOfLowerLetter > 0 && this.numOfDigit > 0 && this.numOfSign > 0) {
            this.setScoreByBonus(5);
        } else if ((numOfUpperLetter > 0 || numOfLowerLetter > 0) && numOfDigit > 0 && numOfSign > 0) {
            this.setScoreByBonus(3);
        } else if ((numOfUpperLetter > 0 || numOfLowerLetter > 0) && numOfDigit > 0) {
            this.setScoreByBonus(2);
        } else {
            this.setScoreByBonus(0);
        }
    }


    private void calScoreBySign() {
        if (this.numOfSign == 0) {
            this.setScoreBySign(0);
        } else if (this.numOfSign == 1) {
            this.setScoreBySign(10);
        } else {
            this.setScoreBySign(25);
        }
    }

    private void calScoreByDigit() {
        if (this.numOfDigit == 0) {
            this.setScoreByDigit(0);
        } else if (this.numOfDigit == 1) {
            this.setScoreByDigit(10);
        } else {
            this.setScoreByDigit(20);
        }
    }

    private void calScoreByLetter() {
        if (this.numOfUpperLetter == 0 && this.numOfLowerLetter == 0) {
           this.setScoreByLetter(0);
        } else if ((this.numOfUpperLetter == 0 && this.numOfLowerLetter > 0) || (this.numOfLowerLetter == 0 && this.numOfUpperLetter > 0)) {
            this.setScoreByLetter(10);
        } else {
            this.setScoreByLetter(20);
        }
    }

    private static boolean isUpperLetter(char c) {
        return c >= 0x41 && c <= 0x5A;
    }

    private static boolean isLowerLetter(char c) {
        return c >= 0x61 && c <= 0x7A;
    }

    private static boolean isDigit(char c) {
        return c >= 0x30 && c <= 0x39;
    }

    private void calScoreByPasswordLength() {
        if (this.password.length() <= 4) {
            this.setScoreByPasswordLength(5);
        } else if (this.password.length() >= 5 && this.password.length() <= 7) {
            this.setScoreByPasswordLength(10);
        } else {
            this.setScoreByPasswordLength(25);
        }
    }

    public int getNumOfUpperLetter() {
        return numOfUpperLetter;
    }

    public void setNumOfUpperLetter(int numOfUpperLetter) {
        this.numOfUpperLetter = numOfUpperLetter;
    }

    public int getNumOfLowerLetter() {
        return numOfLowerLetter;
    }

    public void setNumOfLowerLetter(int numOfLowerLetter) {
        this.numOfLowerLetter = numOfLowerLetter;
    }

    public int getNumOfDigit() {
        return numOfDigit;
    }

    public void setNumOfDigit(int numOfDigit) {
        this.numOfDigit = numOfDigit;
    }

    public int getNumOfSign() {
        return numOfSign;
    }

    public void setNumOfSign(int numOfSign) {
        this.numOfSign = numOfSign;
    }

    public int getScoreByPasswordLength() {
        return scoreByPasswordLength;
    }

    public void setScoreByPasswordLength(int scoreByPasswordLength) {
        this.scoreByPasswordLength = scoreByPasswordLength;
    }

    public int getScoreByLetter() {
        return scoreByLetter;
    }

    public void setScoreByLetter(int scoreByLetter) {
        this.scoreByLetter = scoreByLetter;
    }

    public int getScoreByDigit() {
        return scoreByDigit;
    }

    public void setScoreByDigit(int scoreByDigit) {
        this.scoreByDigit = scoreByDigit;
    }

    public int getScoreBySign() {
        return scoreBySign;
    }

    public void setScoreBySign(int scoreBySign) {
        this.scoreBySign = scoreBySign;
    }

    public int getScoreByBonus() {
        return scoreByBonus;
    }

    public void setScoreByBonus(int scoreByBonus) {
        this.scoreByBonus = scoreByBonus;
    }

    public int getSumScore() {
        return sumScore;
    }

    public void setSumScore(int sumScore) {
        this.sumScore = sumScore;
    }

    public String getStrengthLevel() {
        return strengthLevel;
    }

    public void setStrengthLevel(String strengthLevel) {
        this.strengthLevel = strengthLevel;
    }
}
