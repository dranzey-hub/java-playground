package CodeSignal.FICOTest;

public class E1
{
    public static void main(String[] args) {
        String source = "Codesignal";
        String target = "CodeSignal";

        System.out.println(canTransform(source, target));
    }



    static boolean canTransform(String source, String target)
    {
        //1st
        //check how many differences
        int errs = 0;
        for(int i=0; i<source.length(); i++){
            char s = source.charAt(i);
            char t = target.charAt(i);

            if(s != t)  errs++;
        }


        return false;
    }

}
