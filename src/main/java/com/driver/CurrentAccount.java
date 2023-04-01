package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception

        super(name, balance, 5000);
        this.tradeLicenseId = tradeLicenseId;
        if(balance<5000)
            throw new Exception("Insufficient Balance");
    }

    public CurrentAccount(){

    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        if(!isLicenseIdValid())
        {
            int n = this.tradeLicenseId.length();
            int freq[] = new int[26];
            char chArr[] = new char[n];
            for(int i=0;i<n;i++)
            {
                char ch = this.tradeLicenseId.charAt(i);
                freq[ch-'A']++;
            }
            char maxCh = getMaxFreqCh(freq);
            int maxCount = freq[maxCh-'A'];
            if(n%2!=0 && maxCount>(n/2)+2)
            {
                throw new Exception("Valid License can not be generated");
            }
            else if(n%2==0 && maxCount>n/2+1)
            {
                throw new Exception("Valid License can not be generated");
            }
            int index = 0;
            for(index=0;index<n;index+=2)
            {
                if(freq[maxCh-'A']>0)
                {
                    chArr[index] = maxCh;
                    freq[maxCh-'A']--;
                }
            }
            for(int i=0;i<freq.length;i++)
            {
                char ch = (char)(i+(int)'A');
                while(freq[i]>0)
                {
                    if(index>n-1)
                    {
                        index = 1;
                    }
                    chArr[index] = ch;
                    index += 2;
                    freq[i]--;
                }
            }
            this.tradeLicenseId = "";
            for(char ch: chArr)
            {
                this.tradeLicenseId += ch;
            }
        }

    }
    private char getMaxFreqCh(int freq[])
    {
        int maxFreq = Integer.MIN_VALUE;
        char maxCh = 'A';
        for(int i=0;i<freq.length;i++)
        {
            if(freq[i]>maxFreq)
            {
                maxFreq = freq[i];
                maxCh = (char)(i+(int)'A');
            }
        }
        return maxCh;
    }
    private boolean isLicenseIdValid()
    {
        for(int i=0;i<this.tradeLicenseId.length()-1;i++)
        {
            if(this.tradeLicenseId.charAt(i)==this.tradeLicenseId.charAt(i+1))
                return false;
        }
        return true;
    }

}
