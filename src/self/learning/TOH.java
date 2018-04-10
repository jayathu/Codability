package self.learning;

public class TOH {

    static void SolveTOH(int n)
    {
        MoveDisks(n, "source", "destination", "buffer");
    }

    static void MoveDisks(int n, String source, String destination, String buffer)
    {
        if(n > 0)
        {
            MoveDisks(n-1, source, buffer, destination);
            System.out.println("DISK "+ n + ": " + source + " to " + destination);
            MoveDisks(n-1, buffer, destination, source);
        }
    }
}
