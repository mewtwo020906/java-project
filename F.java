public class F{
    static int k;
    public static void main(String[] args){
        
        int count = 0;

        for( int i = 2 ; i < 1001 ; i++){
            boolean isPrime = true;
            for( int j = 2 ; j < i ; j++){
                if( i % j ==0 ){
                    isPrime = false;
                    break;
                }
            }
                System.out.print( isPrime ? i + "是素数 ": "" );
                if(isPrime){
                    count++;
                    if(count % 10 == 0){
                        System.out.println();
                }
            }
        

        }
        System.out.println("从1到1000中素数一共有" + count);
    }
}