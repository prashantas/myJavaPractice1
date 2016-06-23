package RiaPack;

class TestClass {
    public static void main(String args[] ) throws Exception {
       
       // Read input from stdin and provide input before running

       /* BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            System.out.println("hello world");
        }*/
        int n = Integer.parseInt(args[0]);
        if(args.length != (n-1) )
           System.out.print("wrobg");
        

        System.out.println("Hello World!:: n :" + n);
    }
}

