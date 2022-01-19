package com.sbrf.reboot.repository.impl;

import com.sbrf.reboot.repository.AccountRepository;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class FileAccountRepository implements AccountRepository {

    String filePath;

    public FileAccountRepository(String filePath) throws FileNotFoundException {
        if (filePath.endsWith(".txt")){
            this.filePath = filePath;
        } throw new FileNotFoundException("No file");
    }

    @Override
    public Set<Long> getAllAccountsByClientId(long clientId) {

        Set<Long> numbers = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while (((line = br.readLine()) != null)) {
                stringBuilder.append(line);
            }

            String num = stringBuilder.toString().replaceAll("\\D+","");
            for (int i = 0; i <num.length(); i++) {
                String val = String.valueOf(i);
                if (val.equals(clientId)) {
                    Long res = Long.valueOf(num.substring(Integer.parseInt(val), 4));
                    numbers.add(res);
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return numbers;


    }

    @Override
    public void addClientContract(long clientId, long contractNumber) {

    }
}
