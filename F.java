public class F{
    public static void main(String[] args){
        System.out.println(mulitiply(3));
    }
    public static int mulitiply(int i){
        if (i > 1) {
            return i * mulitiply(i-1);
        }else{
            return 1;
        }
    }

}