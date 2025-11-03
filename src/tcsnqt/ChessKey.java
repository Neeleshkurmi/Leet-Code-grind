package tcsnqt;

import java.util.*;

public class ChessKey {

    static class Piece {
        char type;
        int x, y; // 0-7, where (0,0) is A1

        Piece(char type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return type + "" + (char)('A' + x) + (y + 1);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Piece piece = (Piece) o;
            return type == piece.type && x == piece.x && y == piece.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(type, x, y);
        }
    }

    static class BoardState {
        List<Piece> pieces;

        BoardState(List<Piece> pieces) {
            this.pieces = new ArrayList<>(pieces);
            // Sort pieces for unique string representation
            this.pieces.sort(Comparator.comparing(p -> p.type + "" + p.x + p.y));
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Piece p : pieces) {
                sb.append(p.toString()).append(" ");
            }
            return sb.toString().trim();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BoardState that = (BoardState) o;
            return Objects.equals(pieces, that.pieces);
        }

        @Override
        public int hashCode() {
            return Objects.hash(pieces);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] initialPositions = scanner.nextLine().split(" ");
        int d = scanner.nextInt();
        scanner.close();

        List<Piece> initialPieces = new ArrayList<>();
        for (String pos : initialPositions) {
            char type = pos.charAt(0);
            int x = pos.charAt(1) - 'A';
            int y = pos.charAt(2) - '1';
            initialPieces.add(new Piece(type, x, y));
        }

        BoardState initialBoard = new BoardState(initialPieces);

        Set<String> uniquePositions = new HashSet<>();
        Queue<BoardState> queue = new LinkedList<>();

        uniquePositions.add(initialBoard.toString());
        queue.add(initialBoard);

        for (int i = 0; i < d; i++) {
            Set<String> newPositionsThisPly = new HashSet<>();
            int currentLevelSize = queue.size();
            for (int j = 0; j < currentLevelSize; j++) {
                BoardState currentBoard = queue.poll();
                
                Set<BoardState> nextStates = getMoves(currentBoard);
                
                for (BoardState nextState : nextStates) {
                    String stateString = nextState.toString();
                    if (uniquePositions.add(stateString)) {
                        newPositionsThisPly.add(stateString);
                        queue.add(nextState);
                    }
                }
            }
        }

        System.out.println(uniquePositions.size() - 1); // Subtract 1 for the initial position
    }

    private static Set<BoardState> getMoves(BoardState currentBoard) {
        Set<BoardState> nextStates = new HashSet<>();
        Set<String> occupiedSquares = new HashSet<>();
        for(Piece p : currentBoard.pieces) {
            occupiedSquares.add(p.x + "," + p.y);
        }

        for (int i = 0; i < currentBoard.pieces.size(); i++) {
            Piece movingPiece = currentBoard.pieces.get(i);
            
            Set<String> legalMoves = new HashSet<>();
            if (movingPiece.type == 'Q' || movingPiece.type == 'R') {
                addRookMoves(movingPiece, occupiedSquares, legalMoves);
            }
            if (movingPiece.type == 'Q' || movingPiece.type == 'B') {
                addBishopMoves(movingPiece, occupiedSquares, legalMoves);
            }
            
            for (String move : legalMoves) {
                String[] parts = move.split(",");
                int newX = Integer.parseInt(parts[0]);
                int newY = Integer.parseInt(parts[1]);

                List<Piece> nextPieces = new ArrayList<>(currentBoard.pieces);
                Piece newMovingPiece = new Piece(movingPiece.type, newX, newY);
                nextPieces.set(i, newMovingPiece);
                
                nextStates.add(new BoardState(nextPieces));
            }
        }
        return nextStates;
    }

    private static void addRookMoves(Piece p, Set<String> occupied, Set<String> legalMoves) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < 4; i++) {
            for (int dist = 1; dist < 8; dist++) {
                int newX = p.x + dx[i] * dist;
                int newY = p.y + dy[i] * dist;

                if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
                    String pos = newX + "," + newY;
                    if (!occupied.contains(pos)) {
                        legalMoves.add(pos);
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }
    
    private static void addBishopMoves(Piece p, Set<String> occupied, Set<String> legalMoves) {
        int[] dx = {1, 1, -1, -1};
        int[] dy = {1, -1, 1, -1};

        for (int i = 0; i < 4; i++) {
            for (int dist = 1; dist < 8; dist++) {
                int newX = p.x + dx[i] * dist;
                int newY = p.y + dy[i] * dist;

                if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
                    String pos = newX + "," + newY;
                    if (!occupied.contains(pos)) {
                        legalMoves.add(pos);
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }
}