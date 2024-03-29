package example.archive.utils;

import example.archive.entities.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestEntitiesSupplier {

    public static List<File> getFiles(){
        return getFiles(2);
    }

    public static List<Inventory> getInventories(){
        return getInventories(2);
    }

    public static List<Fund> getFunds(){
        return getFunds(2);
    }

    public static List<Fund> getFunds(int count) {
        List<Fund> funds = new ArrayList<>();
        for (int i = 0; i < count; i++) funds.add(getFund());
        return funds;
    }

    public static List<Inventory> getInventories(int count){
        List<Inventory> inventories = new ArrayList<>();
        for (int i = 0; i < count; i++) inventories.add(getInventory());
        return inventories;
    }

    public static List<File> getFiles(int count){
        List<File> files = new ArrayList<>();
        for (int i = 0; i <count; i++) files.add(getFile());
        return files;
    }

    public static Fund getFund(){
        Fund fund = new Fund();
        boolean letter = new Random().nextBoolean();
        fund.setLetter(letter?"р":null);
        fund.setCurrentFundName(getFundName(fund));
        fund.setInventories(getInventories());
        fund.setNumber("номер фонда");
        List<FundName> oldNames = Arrays.asList(getFundName(fund),getFundName(fund),getFundName(fund),getFundName(fund));
        fund.setOldNames(oldNames);
        return fund;
    }

    public static FundName getFundName(Fund fund){
        return FundName.builder()
                .fund(fund)
                .name("имя фонда")
                .fromDate(LocalDate.now())
                .build();
    }

    public static Inventory getInventory(){
        return Inventory
                .builder()
                .files(getFiles())
                .number("номер описи")
                .introduction("введение в опись")
                .build();
    }

    public static File getFile(){
        File file = File.builder()
                .annotation("аннотация дела")
                .heading("оглавление дела")
                .sheetCount(100)
                .docType("бумажный/фото")
                .nominal("чей-то")
                .dropout(false)
                .defectsType('a')
                .build();
        file.setCurrentNumber(getFileNumber());
        return file;
    }

    public static FileNumber getFileNumber(){
        return FileNumber.builder()
                .number("номер дела")
                .build();
    }
}
