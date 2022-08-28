package game.of.life;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class GameOfLife {

    private final ArrayList<List<Integer>> grid;

    public GameOfLife(ArrayList<List<Integer>> grid) {
        this.grid = grid;
    }

    public ArrayList<List<Integer>> nextGeneration() {
        ArrayList<List<Integer>> resultList = new ArrayList<List<Integer>>();

        for (int rowPosition = 0; rowPosition < grid.size(); rowPosition++) {
            List<Integer> newList = new ArrayList<>();
            for (int columnPosition = 0; columnPosition < grid.get(rowPosition).size(); columnPosition++) {
                int aliveNeighbours = 0;
                List<Integer> currentColumn = grid.get(rowPosition);

                if (rowPosition == 0) {
                    if (columnPosition == 0) {
                        Integer neighbourSide1 = currentColumn.get(columnPosition + 1);

                        List<Integer> downColumn = grid.get(rowPosition + 1);

                        Integer neighbourDown1 = downColumn.get(columnPosition);
                        Integer neighbourDown2 = downColumn.get(columnPosition + 1);

                        aliveNeighbours = neighbourSide1 + neighbourDown1 + neighbourDown2;
                    }
                    else if (columnPosition == currentColumn.size() - 1) {
                        Integer neighbourSide1 = currentColumn.get(columnPosition - 1);

                        List<Integer> downColumn = grid.get(rowPosition + 1);

                        Integer neighbourDown1 = downColumn.get(columnPosition);
                        Integer neighbourDown2 = downColumn.get(columnPosition - 1);

                        aliveNeighbours = neighbourSide1 + neighbourDown1 + neighbourDown2;
                    }

                    else {
                        Integer neighbourSide1 = currentColumn.get(columnPosition - 1);
                        Integer neighbourSide2 = currentColumn.get(columnPosition + 1);

                        List<Integer> downColumn = grid.get(rowPosition + 1);

                        Integer neighbourDown1 = downColumn.get(columnPosition - 1);
                        Integer neighbourDown2 = downColumn.get(columnPosition);
                        Integer neighbourDown3 = downColumn.get(columnPosition + 1);

                        aliveNeighbours = neighbourSide1 + neighbourSide2 + neighbourDown1 + neighbourDown2 + neighbourDown3;

                    }

                } else if (rowPosition == grid.size() - 1) {
                    if (columnPosition == 0) {
                        Integer neighbourSide1 = currentColumn.get(columnPosition + 1);

                        List<Integer> upColumn = grid.get(rowPosition - 1);

                        Integer neighbourUp1 = upColumn.get(columnPosition + 1);
                        Integer neighbourUp2 = upColumn.get(columnPosition);

                        aliveNeighbours = neighbourSide1 + neighbourUp1 + neighbourUp2;
                    }

                    else if (columnPosition == currentColumn.size() - 1) {
                        Integer neighbourSide1 = currentColumn.get(columnPosition - 1);

                        List<Integer> upColumn = grid.get(rowPosition - 1);

                        Integer neighbourUp1 = upColumn.get(columnPosition - 1);
                        Integer neighbourUp2 = upColumn.get(columnPosition);

                        aliveNeighbours = neighbourSide1 + neighbourUp1 + neighbourUp2;
                    }

                    else {
                        Integer neighbourSide1 = currentColumn.get(columnPosition - 1);
                        Integer neighbourSide2 = currentColumn.get(columnPosition + 1);

                        List<Integer> upColumn = grid.get(rowPosition - 1);

                        Integer neighbourUp1 = upColumn.get(columnPosition - 1);
                        Integer neighbourUp2 = upColumn.get(columnPosition);
                        Integer neighbourUp3 = upColumn.get(columnPosition + 1);

                        aliveNeighbours = neighbourSide1 + neighbourSide2 + neighbourUp1 + neighbourUp2 + neighbourUp3;
                    }

                } else {
                    if (columnPosition == 0) {
                        Integer neighbourSide1 = currentColumn.get(columnPosition + 1);

                        List<Integer> upColumn = grid.get(rowPosition - 1);

                        Integer neighbourUp1 = upColumn.get(columnPosition);
                        Integer neighbourUp2 = upColumn.get(columnPosition + 1);

                        List<Integer> downColumn = grid.get(rowPosition + 1);
                        Integer neighbourDown1 = downColumn.get(columnPosition);
                        Integer neighbourDown2 = downColumn.get(columnPosition + 1);

                        aliveNeighbours = neighbourSide1 + neighbourUp1 + neighbourUp2 + neighbourDown1 + neighbourDown2;
                    }

                    else if (columnPosition == currentColumn.size() - 1) {
                        Integer neighbourSide1 = currentColumn.get(columnPosition - 1);

                        List<Integer> upColumn = grid.get(rowPosition - 1);
                        Integer neighbourUp1 = upColumn.get(columnPosition - 1);
                        Integer neighbourUp2 = upColumn.get(columnPosition);

                        List<Integer> downColumn = grid.get(rowPosition + 1);
                        Integer neighbourDown1 = downColumn.get(columnPosition - 1);
                        Integer neighbourDown2 = downColumn.get(columnPosition);

                        aliveNeighbours = neighbourSide1 + neighbourUp1 + neighbourUp2 + neighbourDown1 + neighbourDown2;
                    }

                    else {
                        Integer neighbourSide1 = currentColumn.get(columnPosition - 1);
                        Integer neighbourSide2 = currentColumn.get(columnPosition + 1);

                        List<Integer> upColumn = grid.get(rowPosition - 1);
                        Integer neighbourUp1 = upColumn.get(columnPosition - 1);
                        Integer neighbourUp2 = upColumn.get(columnPosition);
                        Integer neighbourUp3 = upColumn.get(columnPosition + 1);

                        List<Integer> downColumn = grid.get(rowPosition + 1);
                        Integer neighbourDown1 = downColumn.get(columnPosition - 1);
                        Integer neighbourDown2 = downColumn.get(columnPosition);
                        Integer neighbourDown3 = downColumn.get(columnPosition + 1);

                        aliveNeighbours = neighbourSide1 + neighbourSide2 + neighbourUp1 + neighbourUp2 + neighbourUp3 + neighbourDown1 + neighbourDown2 + neighbourDown3;

                    }
                }

                if (currentColumn.get(columnPosition) == 0) {
                    if (aliveNeighbours == 3) {
                        int newCell = 1; // Dead cell is now alive
                        newList.add(newCell);
                    }
                    else {
                        int newCell = 0; // Dead cell remains dead
                        newList.add(newCell);
                    }
                }
                else if (currentColumn.get(columnPosition) == 1) {
                    if (aliveNeighbours < 2 || aliveNeighbours > 3) {
                        int newCell = 0; // Live cell dies by solitude or overcrowding
                        newList.add(newCell);
                    }
                    else {
                        int newCell = 1; // Live cells remains alive
                        newList.add(newCell);
                    }
                }
            }
            resultList.add(newList);
        }
        return resultList;
    }
}

