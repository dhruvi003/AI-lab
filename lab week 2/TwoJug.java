// You are given two jugs with m liters and a n liter capacity.
// Both the jugs are initially empty. 
//The jugs don’t have markings to allow measuring smaller quantities. 
//You have to use the jugs to measure d liters of water where d is less than n.

public class TwoJug{

    public static void main(String[] args) {
        int n =3, m = 5, d = 4;
        System.out.println("Min number of steps: " + minStep(m, n, d));
    }

    static int gcd(int a, int b){
        
        if(b == 0){
            return a;
        }

        return gcd(b, a%b);
    }


    static int solutionOne(int m, int n,int d){

        int mFullVal = m;
        int nFullVal = 0;
        int count = 1;

        while(mFullVal != d || nFullVal != d){
            // fill m litre jig
            mFullVal = m;
            count++;

            // pouring from m to n
            int toBeTransformed = Math.min(mFullVal, n-nFullVal);
            nFullVal += toBeTransformed;
            mFullVal -= toBeTransformed;

            count ++;

            //if n is full, empty it
            if(nFullVal == d || mFullVal==d){
                break;
            }

            if(mFullVal == 0){
                mFullVal = m;
                count++;
            }

            if(nFullVal == n){
                nFullVal=0;
                count++;
            }

        }
        System.out.println("Number of operations for One : " + count);

        return count;
    }

   public static int minStep(int m, int n, int d){
    if(m > n){
        int temp = m;
        m = n;
        n = temp;

    }

    if(d > n){
        return -1;
    }

    if((d % gcd(n, m)) != 0){
        return -1;
    }

    return Math.min(solutionOne(m, n, d), solutionOne(n, m, d));
   }

    
}
