package treePrinter.printer.traditional;

import java.util.List;

import treePrinter.util.LineBuffer;

public interface Liner {
    
    public int printConnections(LineBuffer buffer, int row, int topConnection, List<Integer> bottomConnections);
    
}