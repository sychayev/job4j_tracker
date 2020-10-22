package ru.job4j.tracker;

public class ValidateInput implements Input{
private Input in;
private Output out;

public ValidateInput(Output out,Input input){
    this.out = out;
    this.in = input;
}


    @Override
    public String askStr(String question) {
        return in.askStr(question);
    }


    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do{
            try{
                value = in.askInt(question);
                invalid = false;
            }catch (NumberFormatException efn){
                out.println("Please enter validate data again");
            }
        }while(invalid);

        return value;
    }
//    @Override
//    public int askInt(String question) {
//        boolean invalid = true;
//        int value = -1;
//        do{
//            try{
//                value = super.askInt(question);
//                invalid = false;
//            }catch(NumberFormatException e){
//                System.out.println("Please enter validate data again.");
//            }
//        }
//        while(invalid);
//        return value;
//    }
}
