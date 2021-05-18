import java.util.*;
import java.lang. *;

public class Astar {

    private Board initial;
    private List<Board> result = new ArrayList<Board>();   // цепочка ходов, приводящих к решению задачи

    private class ITEM{    // Чтобы узнать длину пути, нам нужно помнить предидущие позиции (и не только поэтому)
        private ITEM prevBoard;
        private Board board;

        private ITEM(ITEM prevBoard, Board board) {
            this.prevBoard = prevBoard;
            this.board = board;
        }

        public Board getBoard() {
            return board;
        }


    }

    public Astar(Board initial) {
        this.initial = initial;

        if(!isSolvable()) return;

        //  очередь для нахождения приоритетного сравниваем меры
        PriorityQueue<ITEM> priorityQueue = new PriorityQueue<ITEM>(10, new Comparator<ITEM>() {
            @Override
            public int compare(ITEM o1, ITEM o2) {
                return new Integer(measure(o1)).compareTo(new Integer(measure(o2)));
            }
        });


        // шаг 1
        priorityQueue.add(new ITEM(null, initial));

        while (true){
            ITEM board = priorityQueue.poll();

            //   если дошли до решения, сохраняем весь путь ходов в лист
            if(board.board.isGoal()) {
                itemToList(new ITEM(board, board.board));
                return;
            }


            Iterator iterator = board.board.neighbors().iterator(); // соседи
            while (iterator.hasNext()){
                Board board1 = (Board) iterator.next();

                //оптимизация. Очевидно, что один из соседей - это позиция
                // которая была ходом раньше. Чтобы не возвращаться в состояния,
                // которые уже были делаем проверку. Экономим время и память.
                if(board1!= null && !containsInPath(board, board1))
                    priorityQueue.add(new ITEM(board, board1));
            }

        }
    }

    private static int measure(ITEM item){
        ITEM item2 = item;
        int c= 0;   // g(x)
        int measure = item.getBoard().h();  // h(x)
        while (true){
            c++;
            item2 = item2.prevBoard;
            if(item2 == null) {
                // g(x) + h(x)
                return measure + c;
            }
        }
    }

    //  сохранение
    private void itemToList(ITEM item){
        ITEM item2 = item;
        while (true){
            item2 = item2.prevBoard;
            if(item2 == null) {
                Collections.reverse(result);
                return;
            }
            result.add(item2.board);
        }
    }

    // была ли уже такая позиция в пути
    private boolean containsInPath(ITEM item, Board board){
        ITEM item2 = item;
        while (true){
            if(item2.board.equals(board)) return true;
            item2 = item2.prevBoard;
            if(item2 == null) return false;
        }
    }


    public boolean isSolvable() {
        return true;
    }

    public int moves() {
        if(!isSolvable()) return -1;
        return result.size() - 1;
    }


    public Iterable<Board> solution() {
        return result;
    }


}