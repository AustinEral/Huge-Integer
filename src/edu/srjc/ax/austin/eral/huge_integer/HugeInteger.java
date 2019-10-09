/*
Austin Eral
austineral@ymail.com
3/29/2017
AX_Austin_Eral Huge Integer
CS 17.11

This class is designed to allow users to store numbers that are immensely
larger than any primitive data. It also allows simple operations of the
numbers. The division algorithm is pretty inefficient so avoid that if you can.
 */

package edu.srjc.ax.austin.eral.huge_integer;

public class HugeInteger
{
    private int maxDigits;
    
    private int[] internalValue;
    
    private boolean isNegativeNumber = false;
    
    
    //-----------------------------Constructors------------------------------//
    
    
    public HugeInteger(String val, int numOfDigits)
    {
        maxDigits = numOfDigits;
        privateParse(val);
    }
    
    
    public HugeInteger(int numOfDigits)
    {
        maxDigits = numOfDigits;
        internalValue = new int[maxDigits];
    }
    
    
    public HugeInteger(HugeInteger other)
    {
        this.maxDigits = other.maxDigits;
        privateParse(other.toString());
    }
    
    
    //--------------------------------Helpers--------------------------------//
    
    
    public void parse(String val)
    {
        privateParse(val);
    }
    
    
    private void privateParse(String val)
    {
        if (val.startsWith("-"))
        {
            if (val.length() == 1)
            {
                privateParse("0");
                return;
            }
            isNegativeNumber = true;
            val = val.substring(1);
        }
        else
        {
            isNegativeNumber = false;
        }
        internalValue = new int[maxDigits];
        
        if (val.length() == 0)
        {
            throw new IllegalArgumentException("Nothing specified!");
        }
        if (val.length() > maxDigits)
        {
            throw new IllegalArgumentException("Too long!");
        }
        
        for (int i = 0; i < val.length(); i++)
        {
            if (!Character.isDigit(val.charAt(i)))
            {
                throw new IllegalArgumentException("Bad character in input");
            }
        }
        
        int rightSide = maxDigits - 1;
        for (int i = val.length() - 1; i >= 0; i--)
        {
            internalValue[rightSide] = ((int) val.charAt(i)) - '0';
            rightSide -= 1;
        }
        if (this.toString().equals("-"))
        {
            isNegativeNumber = false;
        }
    }
    
    
    public String toString()
    {
        boolean nonZeroFound = false;
        StringBuilder sb = new StringBuilder();
        if (this.isNegativeNumber)
        {
            sb.append('-');
        }
        for (int i = 0; i < maxDigits; i++)
        {
            if (!(internalValue[i] == 0) && !nonZeroFound)
            {
                //sb.append((char)(internalValue[i] + '0'));
                nonZeroFound = true;
            }
            if (nonZeroFound)
            {
                sb.append((char) (internalValue[i] + '0'));
                
            }
            
        }
        if (sb.toString().length() == 0)
        {
            sb.append("0");
        }
        return sb.toString();
    }
    
    
    //-------------------------Math Operation Methods------------------------//
    
    
    public void add(HugeInteger addend)
    {
        HugeInteger otherHugeInt = new HugeInteger(addend.toString(), maxDigits);
        privateAdd(otherHugeInt);
    }
    
    
    public void add(int addend)
    {
        String val = Integer.toString(addend);
        HugeInteger otherHugeInt = new HugeInteger(val, maxDigits);
        privateAdd(otherHugeInt);
    }
    
    
    public void add(long addend)
    {
        String val = Long.toString(addend);
        HugeInteger otherHugeInt = new HugeInteger(val, maxDigits);
        privateAdd(otherHugeInt);
    }
    
    
    private void privateAdd(HugeInteger addend)
    {
        if (this.isNegativeNumber ^ addend.isNegativeNumber)
        {
            if (this.isNegativeNumber)
            {
                HugeInteger temp = new HugeInteger(this);
                temp.isNegativeNumber = false;
                addend.privateSubtract(temp);
                this.privateParse(addend.toString());
            }
            else
            {
                HugeInteger temp = new HugeInteger(addend);
                temp.isNegativeNumber = false;
                this.privateSubtract(temp);
            }
        }
        else
        {
            int carry = 0;
            for (int index = maxDigits - 1; index >= 0; index--)
            {
                int firstNumber = this.internalValue[index];
                int secondNumber = addend.internalValue[index];
                
                int newVal = firstNumber + secondNumber + carry;
                if (newVal >= 10)
                {
                    carry = 1;
                    this.internalValue[index] = newVal - 10;
                    if (index == 0)
                    {
                        throw new IllegalArgumentException("Solution too large.");
                    }
                }
                else
                {
                    carry = 0;
                    this.internalValue[index] = newVal;
                }
            }
        }
    }
    
    
    public void subtract(HugeInteger subtrahend)
    {
        HugeInteger otherHugeInt = new HugeInteger(subtrahend.toString(), maxDigits);
        privateSubtract(subtrahend);
    }
    
    
    public void subtract(int subtrahend)
    {
        String val = Integer.toString(subtrahend);
        HugeInteger otherHugeInt = new HugeInteger(val, maxDigits);
        privateSubtract(otherHugeInt);
    }
    
    
    public void subtract(long subtrahend)
    {
        String val = Long.toString(subtrahend);
        HugeInteger otherHugeInt = new HugeInteger(val, maxDigits);
        privateSubtract(otherHugeInt);
    }
    
    
    private void privateSubtract(HugeInteger subtrahend)
    {
        HugeInteger minuend = new HugeInteger(this);
        
        if (subtrahend.maxDigits > minuend.maxDigits)
        {
            minuend = new HugeInteger(minuend.toString(), subtrahend.maxDigits);
        }
        else if (subtrahend.maxDigits < minuend.maxDigits)
        {
            subtrahend = new HugeInteger(subtrahend.toString(), minuend.maxDigits);
        }
        
        if (minuend.isNegativeNumber ^ subtrahend.isNegativeNumber)
        {
            subtrahend.isNegativeNumber = minuend.isNegativeNumber;
            minuend.add(subtrahend);
        }
        else
        {
            if (minuend.absoluteValue().isLessThan(subtrahend.absoluteValue()))
            {
                HugeInteger temp = new HugeInteger(minuend);
                minuend = new HugeInteger(subtrahend);
                subtrahend = new HugeInteger(temp);
                minuend.isNegativeNumber = !minuend.isNegativeNumber;
            }
            
            
            int borrow = 0;
            for (int index = minuend.maxDigits - 1; index >= 0; index--)
            {
                
                int firstNumber = minuend.internalValue[index];
                int secondNumber = subtrahend.internalValue[index];
                int newVal;
                
                if ((firstNumber - secondNumber - borrow) < 0)
                {
                    firstNumber += 10;
                    newVal = firstNumber - secondNumber - borrow;
                    borrow = 1;
                }
                else
                {
                    newVal = firstNumber - secondNumber - borrow;
                    borrow = 0;
                }
                
                minuend.internalValue[index] = newVal;
            }
        }
        this.privateParse(minuend.toString());
    }
    
    
    private HugeInteger absoluteValue()
    {
        HugeInteger other = new HugeInteger(this);
        other.isNegativeNumber = false;
        return other;
    }
    
    
    public void multiply(HugeInteger multiplicand)
    {
        HugeInteger otherHugeInt = new HugeInteger(multiplicand.toString(), maxDigits);
        privateMultiply(otherHugeInt);
    }
    
    
    public void multiply(int multiplicand)
    {
        String val = Integer.toString(multiplicand);
        HugeInteger otherHugeInt = new HugeInteger(val, maxDigits);
        privateMultiply(otherHugeInt);
    }
    
    
    public void multiply(long multiplicand)
    {
        String val = Long.toString(multiplicand);
        HugeInteger otherHugeInt = new HugeInteger(val, maxDigits);
        privateMultiply(otherHugeInt);
    }
    
    
    private void privateMultiply(HugeInteger multiplicand)
    {
        HugeInteger product = new HugeInteger(maxDigits);
        int shift = 0;
        for (int index = multiplicand.maxDigits - 1; index >= 0; index--)
        {
            HugeInteger addend = new HugeInteger(maxDigits);
            int firstNumber = this.internalValue[index];
            int carry = 0;
            
            for (int otherIndex = this.maxDigits - 1; otherIndex - shift >= 0; otherIndex--)
            {
                int secondNumber = multiplicand.internalValue[otherIndex];
                addend.internalValue[(otherIndex - shift)] = ((firstNumber * secondNumber) % 10) + carry;
                carry = (firstNumber * secondNumber) / 10;
            }
            
            if (carry > 0)
            {
                throw new IllegalArgumentException("Product too large.");
            }
            shift++;
            product.privateAdd(addend);
        }
        
        product.isNegativeNumber = (this.isNegativeNumber ^ multiplicand.isNegativeNumber);
        this.privateParse(product.toString());
    }
    
    
    public void divide(HugeInteger divisor)
    {
        HugeInteger otherHugeInt = new HugeInteger(divisor.toString(), maxDigits);
        privateDivide(otherHugeInt);
    }
    
    
    public void divide(int divisor)
    {
        String val = Integer.toString(divisor);
        HugeInteger otherHugeInt = new HugeInteger(val, maxDigits);
        privateDivide(otherHugeInt);
    }
    
    
    public void divide(long divisor)
    {
        String val = Long.toString(divisor);
        HugeInteger otherHugeInt = new HugeInteger(val, maxDigits);
        privateDivide(otherHugeInt);
    }
    
    
    // This second divide helps speed up the division process when a large
    // number is being divided by a small number, but it is still pretty
    // inefficient.
    private void privateDivide(HugeInteger divisor)
    {
        if (divisor.isGreaterThan(1000000))
        {
            privateDivide2(divisor);
            return;
        }
        if (divisor.isEqualTo(0))
        {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        boolean sign = (this.isNegativeNumber ^ divisor.isNegativeNumber);
        
        if (divisor.isEqualTo(1))
        {
            this.isNegativeNumber = sign;
            if (this.isEqualTo(0))
            {
                this.isNegativeNumber = false;
            }
            return;
        }
        
        this.parse(absoluteValue().toString());
        divisor.parse(divisor.absoluteValue().toString());
        
        HugeInteger originalDivisor = new HugeInteger(divisor);
        HugeInteger remainder = new HugeInteger(this);
        HugeInteger quotient = new HugeInteger(maxDigits);
        HugeInteger multiple = new HugeInteger("1", maxDigits);
        int power;
        
        while (remainder.isGreaterThanOrEqualTo(originalDivisor))
        {
            multiple.parse("1");
            divisor.privateParse(originalDivisor.toString());
            for (power = 1; divisor.isLessThan(remainder); power++)
            {
                divisor.multiply(originalDivisor);
            }
            power--;
            divisor = new HugeInteger(originalDivisor);
            for (int count = 1; count < power; count++)
            {
                divisor.multiply(originalDivisor);
                multiple.multiply(originalDivisor);
            }
            remainder.subtract(divisor);
            quotient.add(multiple);
            if (remainder.toString().equals(originalDivisor.toString()))
            {
                quotient.add(1);
                break;
            }
        }
        this.privateParse(quotient.toString());
        if (this.isNotEqualTo(0))
        {
            this.isNegativeNumber = sign;
        }
    }
    
    
    // This second divide helps speed up the division process when a large
    // number is being divided by a small number, but it is still pretty
    // inefficient.
    public void privateDivide2(HugeInteger divisor)
    {
        if (divisor.isEqualTo(0))
        {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        boolean sign = (this.isNegativeNumber ^ divisor.isNegativeNumber);
        this.parse(absoluteValue().toString());
        divisor.parse(divisor.absoluteValue().toString());
        
        HugeInteger product = new HugeInteger(maxDigits);
        HugeInteger quotient = new HugeInteger(maxDigits);
        while (this.isGreaterThanOrEqualTo(product))
        {
            product.add(divisor);
            quotient.add(1);
        }
        quotient.subtract(1);
        quotient.isNegativeNumber = sign;
        this.parse(quotient.toString());
    }
    
    
    public void mod(HugeInteger other)
    {
        if (other.isEqualTo(0))
        {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        
        boolean sign = this.isNegativeNumber;
        this.parse(absoluteValue().toString());
        other.parse(other.absoluteValue().toString());
        HugeInteger temp = new HugeInteger(this);
        
        temp.divide(other);
        temp.multiply(other);
        this.subtract(temp);
        
        if (this.isNotEqualTo(0))
        {
            this.isNegativeNumber = sign;
        }
    }
    
    
    public void factorial()
    {
        privateFactorial();
    }
    
    
    private void privateFactorial()
    {
        if (this.isLessThan(0))
        {
            throw new IllegalArgumentException("Cannot factorial negative numbers.");
        }
        else if (this.isEqualTo(0))
        {
            this.parse("1");
        }
        HugeInteger solution = new HugeInteger(maxDigits);
        HugeInteger oneLessThanThis = new HugeInteger(this);
        oneLessThanThis.subtract(1);
        for (HugeInteger count = new HugeInteger(oneLessThanThis); count.isGreaterThan(1); count.subtract(1))
        {
            this.multiply(count);
        }
    }
    
    //-----------------------Boolean Operation Methods-----------------------//
    
    
    public boolean isGreaterThan(HugeInteger other)
    {
        HugeInteger otherHugeInt = new HugeInteger(other.toString(), maxDigits);
        return privateIsGreaterThan(otherHugeInt);
    }
    
    
    public boolean isGreaterThan(int other)
    {
        String val = Integer.toString(other);
        HugeInteger otherHugeInt = new HugeInteger(val, maxDigits);
        return privateIsGreaterThan(otherHugeInt);
    }
    
    
    public boolean isGreaterThan(long other)
    {
        String val = Long.toString(other);
        HugeInteger otherHugeInt = new HugeInteger(val, maxDigits);
        return privateIsGreaterThan(otherHugeInt);
    }
    
    
    private boolean privateIsGreaterThan(HugeInteger other)
    {
        if (this.isNegativeNumber ^ other.isNegativeNumber)
        {
            return !this.isNegativeNumber;
        }
        for (int index = 0; index < maxDigits; index++)
        {
            if (this.internalValue[index] != other.internalValue[index])
            {
                int firstNum = this.internalValue[index];
                int secondNum = secondNum = other.internalValue[index];
                if (this.isNegativeNumber)
                {
                    firstNum = Math.negateExact(firstNum);
                }
                if (other.isNegativeNumber)
                {
                    secondNum = Math.negateExact(secondNum);
                }
                return firstNum > secondNum;
            }
        }
        return false;
    }
    
    
    public boolean isGreaterThanOrEqualTo(HugeInteger other)
    {
        HugeInteger otherHugeInt = new HugeInteger(other.toString(), maxDigits);
        return privateIsGreaterThanOrEqualTo(otherHugeInt);
    }
    
    
    public boolean isGreaterThanOrEqualTo(int other)
    {
        String val = Integer.toString(other);
        HugeInteger otherHugeInt = new HugeInteger(val, maxDigits);
        return privateIsGreaterThanOrEqualTo(otherHugeInt);
    }
    
    
    public boolean isGreaterThanOrEqualTo(long other)
    {
        String val = Long.toString(other);
        HugeInteger otherHugeInt = new HugeInteger(val, maxDigits);
        return privateIsGreaterThanOrEqualTo(otherHugeInt);
    }
    
    
    private boolean privateIsGreaterThanOrEqualTo(HugeInteger other)
    {
        return privateIsGreaterThan(other) || privateIsEqualTo(other);
    }
    
    
    public boolean isLessThan(HugeInteger other)
    {
        HugeInteger otherHugeInt = new HugeInteger(other.toString(), maxDigits);
        return privateIsLessThan(otherHugeInt);
    }
    
    
    public boolean isLessThan(int other)
    {
        String val = Integer.toString(other);
        HugeInteger otherHugeInt = new HugeInteger(val, maxDigits);
        return privateIsLessThan(otherHugeInt);
    }
    
    
    public boolean isLessThan(long other)
    {
        String val = Long.toString(other);
        HugeInteger otherHugeInt = new HugeInteger(val, maxDigits);
        return privateIsLessThan(otherHugeInt);
    }
    
    
    private boolean privateIsLessThan(HugeInteger other)
    {
        return !isGreaterThanOrEqualTo(other);
    }
    
    
    public boolean isLessThanOrEqualTo(HugeInteger other)
    {
        HugeInteger otherHugeInt = new HugeInteger(other.toString(), maxDigits);
        return privateIsLessThanOrEqualTo(otherHugeInt);
    }
    
    
    public boolean isLessThanOrEqualTo(int other)
    {
        String val = Integer.toString(other);
        HugeInteger otherHugeInt = new HugeInteger(val, maxDigits);
        return privateIsLessThanOrEqualTo(otherHugeInt);
    }
    
    
    public boolean isLessThanOrEqualTo(long other)
    {
        String val = Long.toString(other);
        HugeInteger otherHugeInt = new HugeInteger(val, maxDigits);
        return privateIsLessThanOrEqualTo(otherHugeInt);
    }
    
    
    private boolean privateIsLessThanOrEqualTo(HugeInteger other)
    {
        return !privateIsGreaterThan(other);
    }
    
    
    public boolean isEqualTo(HugeInteger other)
    {
        HugeInteger otherHugeInt = new HugeInteger(other.toString(), maxDigits);
        return privateIsEqualTo(otherHugeInt);
    }
    
    
    public boolean isEqualTo(int other)
    {
        String val = Integer.toString(other);
        HugeInteger otherHugeInt = new HugeInteger(val, maxDigits);
        return privateIsEqualTo(otherHugeInt);
    }
    
    
    public boolean isEqualTo(long other)
    {
        String val = Long.toString(other);
        HugeInteger otherHugeInt = new HugeInteger(val, maxDigits);
        return privateIsEqualTo(otherHugeInt);
    }
    
    
    private boolean privateIsEqualTo(HugeInteger other)
    {
        if (this.isNegativeNumber != other.isNegativeNumber)
        {
            return false;
        }
        for (int index = 0; index < maxDigits; index++)
        {
            if (this.internalValue[index] != other.internalValue[index])
            {
                return false;
            }
        }
        return true;
    }
    
    
    public boolean isNotEqualTo(HugeInteger other)
    {
        HugeInteger otherHugeInt = new HugeInteger(other.toString(), maxDigits);
        return privateIsNotEqualTo(otherHugeInt);
    }
    
    
    public boolean isNotEqualTo(int other)
    {
        String val = Integer.toString(other);
        HugeInteger otherHugeInt = new HugeInteger(val, maxDigits);
        return privateIsNotEqualTo(otherHugeInt);
    }
    
    
    public boolean isNotEqualTo(long other)
    {
        String val = Long.toString(other);
        HugeInteger otherHugeInt = new HugeInteger(val, maxDigits);
        return privateIsNotEqualTo(otherHugeInt);
    }
    
    
    private boolean privateIsNotEqualTo(HugeInteger other)
    {
        return !privateIsEqualTo(other);
    }
    
    
    //---------------------------Getters & Setters---------------------------//
}
