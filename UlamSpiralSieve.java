public class UlamSpiralSieve
{
    public static void main(String[] args)
    {
        // Draw a spiral on the screen
        final int SCALE = 400; // default: 200
        final double PEN = 0.002; // default: 0.005
        final int N = SCALE*SCALE; // used as a counter
        // data structure for prime sieve
        
        boolean[] isPrime = new boolean[N+1];
        
        StdDraw.setXscale(0, SCALE);
        StdDraw.setYscale(0, SCALE);
        StdDraw.setPenRadius(PEN);
        
        int x = 0, y = 0;
        
        int step = 1;
        int dirX = 1, dirY = 1;
        
        // StdDraw.clear();
        
        // sieve the prime array
        for (int i = 1; i <= N; i++)
            isPrime[i] = true;
        
        for (int i = 2; i <= N/i; i++)
        {
            if (isPrime[i])
            {
                for (int j = i; j <= N/i; j++)
                    isPrime[i*j] = false;
            }
        }
        
        int count = 1;
        int loops = 0;
        
        while (count <= N)
        {            
            if (loops % 2 == 0)
            {
                for (int j = 0; j < step; j++)
                {
                    if (isPrime[count])
                        StdDraw.setPenColor(StdDraw.BLACK);
                    else
                        StdDraw.setPenColor(StdDraw.WHITE);

                    StdDraw.point(x + SCALE / 2, y + SCALE / 2);
                    // StdDraw.show(5);
                    x += dirX;
                    count++;
                }
                
                dirX *= -1;
            }
            else
            {
                for (int j = 0; j < step; j++)
                {
                    if (isPrime[count])
                        StdDraw.setPenColor(StdDraw.BLACK);
                    else
                        StdDraw.setPenColor(StdDraw.WHITE);

                    StdDraw.point(x + SCALE / 2, y + SCALE / 2);
                    //StdDraw.show(5);
                    y += dirY;
                    count++;
                }
                
                dirY *= -1;
                step++;
            }
            
            loops++;
        }        
    }
}