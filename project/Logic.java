public class Logic {

    private int[][][][] edge = new int[10][10][4][1];
    private int[][][] tag = new int[10][10][1];

    //private int[][][][] edgeTriangle = new int[10][10][3][1];
    //private int[][][] tagTriangle = new int[10][10][1];


    public int[][][][] getEdge() {
        return edge;
    }

    public void setEdge(int[][][][] edge) {
        this.edge = edge;
    }

    public int[][][] getTag() {
        return tag;
    }

    public void setTag(int[][][] tag) {
        this.tag = tag;
    }

    public int getState(MyEdge oneEdge) {
        return edge[oneEdge.getX()][oneEdge.getY()][oneEdge.getDierction()][0];
    }

    public int getState(int x, int y, int direction) {
        return edge[x][y][direction][0];
    }


    public void isClick(int x1, int y1, int x2, int y2) {
        if (x2 == x1 + 1 && y1 == y2) {
            edge[x1][y1][1][0] = 2;
            edge[x2][y2][0][0] = 2;
        }
        if (x2 == x1 - 1 && y1 == y2) {
            edge[x1][y1][0][0] = 2;
            edge[x2][y2][1][0] = 2;
        }
        if (x1 == x2 && y1 == y2 - 1) {
            edge[x1][y1][3][0] = 2;
            edge[x2][y2][2][0] = 2;
        }
        if (x1 == x2 && y1 == y2 + 1) {
            edge[x1][y1][2][0] = 2;
            edge[x2][y2][3][0] = 2;
        }
    }

    public void triangleIsClick(int x, int y, int direction, int m, int n) {
        if(direction == 0){
            if(x == 0){
                x = x + 1;
            }
        }else if(direction == 1){
            if(y == n + 1){
                y = y - 1;
                direction = 2;
            }
        }else if(direction == 2){
            if(y == 0){
                y = y + 1;
                direction = 1;
            }
        }
        if (direction == 0) {
            if (x == 1) {
                if (y % 2 == 0) {
                    edge[x - 1][y - 1][0][0] = 2;
                }
            } else if (x == m) {
                if (y % 2 == 1) {
                    edge[x - 1][y - 1][0][0] = 2;
                }
            } else {
                if (x % 2 == 1) {
                    edge[x - 1][y - 1][0][0] = 2;
                    edge[x][y - 1][0][0] = 2;
                } else if (x==1&&y==1&&direction==0) {
                    edge[0][0][0][0] = 2;
                } else if(x==2&&y==1&&direction==0){
                    edge[1][0][0][0] = 2;
                }else{
                    edge[x - 1][y - 1][0][0] = 2;
                    edge[x - 2][y - 1][0][0] = 2;
                }

            }
        } else {
            if (y == 1) {
                edge[x - 1][y - 1][1][0] = 2;
            } else if (y == n) {
                edge[x - 1][y - 1][2][0] = 2;
            } else {
                if (y % 2 == 1) {
                    edge[x - 1][y - 1][2][0] = 2;
                    edge[x - 1][y][1][0] = 2;
                } else {
                    edge[x - 1][y - 1][1][0] = 2;
                    edge[x - 1][y][2][0] = 2;
                }
            }
        }

    }

    public void isClickTriangle(int x, int y, int direction, int m, int n){
        if(direction == 0){
            if(x == 0){
                x = x + 1;
            }
        }else if(direction == 1){
            if(y == n + 1){
                y = y - 1;
                direction = 2;
            }
        }else if(direction == 2){
            if(y == 0){
                y = y + 1;
                direction = 1;
            }
        }
        if(direction == 0){
            if(x % 2 != y % 2){
                edge[x][y][0][0] = 2;
            }else if(x == m){
                edge[x][y][0][0] = 2;
            }else {
                edge[x + 1][y][0][0] = 2;
                edge[x][y][0][0] = 2;
            }
        }else if(direction == 1){
            if(y == 1 && x % 2 == y % 2){
                edge[x][y][1][0] = 2;
            }else if (x % 2 != y % 2 && y == 1){
                edge[x][y][1][0] = 2;
            } else{
                edge[x][y][1][0] = 2;
                edge[x][y - 1][2][0] = 2;
            }
        }else if(direction == 2){
            if(x % 2 != y % 2 && y == n){
                edge[x][y][2][0] = 2;
            }else if (y == n && x % 2 == y % 2){
                edge[x][y][2][0] = 2;
            } else{
                edge[x][y][2][0] = 2;
                edge[x][y + 1][1][0] = 2;
            }
        }
    }

    public int updateBoard(int m, int n) {
        int times = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (tag[i][j][0] == 0) {
                    if (edge[i][j][0][0] == 2 && edge[i][j][1][0] == 2 && edge[i][j][2][0] == 2 && edge[i][j][3][0] == 2) {
                        times = times + 1;
                    }
                }
            }
        }
        return times;
    }

    public int updateBoardTriangle(int m, int n){

        int times = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (tag[i][j][0] == 0) {
                    if (edge[i][j][0][0] == 2 && edge[i][j][1][0] == 2 && edge[i][j][2][0] == 2 ) {
                        times = times + 1;
                    }
                }
            }
        }
        return times;
    }

    public boolean checkEnd(int m, int n) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (tag[i][j][0] == 1) {
                    count++;
                }

            }
        }
        if (count >= (m - 1) * (n - 1)) {
            return true;//game ends
        } else {
            return false;//game continues
        }
    }

    public void result(User[] user) {
        if (user[0].getScore() > user[1].getScore()) {
            String s = user[0].getName()+"'s score is "+user[0].getScore()+", "+user[0].getName()+" wins";
            LoginWindow.endWINDOW(s);
            //System.out.printf("%s's score is %d, %s wins\n", user[0].getName(), user[0].getScore(), user[0].getName());
        } else if (user[0].getScore() < user[1].getScore()) {
            String s = user[1].getName()+"'s score is "+user[1].getScore()+", "+user[1].getName()+" wins";
            LoginWindow.endWINDOW(s);
            //System.out.printf("%s's score is %d, %s wins\n", user[1].getName(), user[1].getScore(), user[1].getName());
        } else {
            String s = user[0].getName()+" and "+ user[1].getName()+"'s scores are both "+ user[0].getScore()+" game draw";
            LoginWindow.endWINDOW(s);
            //System.out.printf("%s and %s's scores are both %d, game draw\n", user[0].getName(), user[1].getName(), user[0].getScore());
        }
    }

    public int[] findEnclosedTag(int m, int n) {
        int[] place = new int[2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (tag[i][j][0] == 0) {
                    if (edge[i][j][0][0] == 2 && edge[i][j][1][0] == 2) {
                        if (edge[i][j][2][0] == 2 && edge[i][j][3][0] == 2) {
                            tag[i][j][0] = 1;
                            place[0] = i;
                            place[1] = j;
                            return place;
                        }
                    }
                }
            }
        }
        return place;
    }

    public int[] findEnclosedTagTriangle(int m, int n) {
        int[] place = new int[2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (tag[i][j][0] == 0) {
                    if (edge[i][j][0][0] == 2 && edge[i][j][1][0] == 2 && edge[i][j][2][0] == 2) {
                        tag[i][j][0] = 1;
                        place[0] = i;
                        place[1] = j;
                        return place;
                    }
                }
            }
        }
        return place;
    }

    public int[] findTagWithoutOneEdge(int m, int n){
        int[] place = new int[3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (tag[i][j][0] == 0) {
                    if(edge[i][j][0][0] == 0 && edge[i][j][1][0] == 2 && edge[i][j][2][0] == 2 && edge[i][j][3][0] == 2){
                        place[0] = i;
                        place[1] = j;
                        return place;
                    }else if(edge[i][j][0][0] == 2 && edge[i][j][1][0] == 0 && edge[i][j][2][0] == 2 && edge[i][j][3][0] == 2){
                        place[0] = i + 1;
                        place[1] = j;
                        return place;
                    }else if(edge[i][j][0][0] == 2 && edge[i][j][1][0] == 2 && edge[i][j][2][0] == 0 && edge[i][j][3][0] == 2){
                        place[0] = i;
                        place[1] = j;
                        place[2] = 2;
                        return place;
                    }else if(edge[i][j][0][0] == 2 && edge[i][j][1][0] == 2 && edge[i][j][2][0] == 2 && edge[i][j][3][0] == 0){
                        place[0] = i;
                        place[1] = j + 1;
                        place[2] = 2;
                        return place;
                    }
                }
            }
        }
        return place;
    }

    public int[] findTagWithoutTwoEdges(int m, int n){
        int[] place = new int[3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (tag[i][j][0] == 0) {
                    if(edge[i][j][0][0] == 0 && edge[i][j][1][0] == 0 && edge[i][j][2][0] == 2 && edge[i][j][3][0] == 2){
                        place[0] = i;
                        place[1] = j;
                        return place;
                    }else if(edge[i][j][0][0] == 0 && edge[i][j][1][0] == 2 && edge[i][j][2][0] == 0 && edge[i][j][3][0] == 2){
                        place[0] = i + 1;
                        place[1] = j;
                        return place;
                    }else if(edge[i][j][0][0] == 0 && edge[i][j][1][0] == 2 && edge[i][j][2][0] == 2 && edge[i][j][3][0] == 0){
                        place[0] = i;
                        place[1] = j;
                        place[2] = 2;
                        return place;
                    }else if(edge[i][j][0][0] == 2 && edge[i][j][1][0] == 0 && edge[i][j][2][0] == 0 && edge[i][j][3][0] == 2){
                        place[0] = i;
                        place[1] = j + 1;
                        place[2] = 2;
                        return place;
                    }else if(edge[i][j][0][0] == 2 && edge[i][j][1][0] == 2 && edge[i][j][2][0] == 0 && edge[i][j][3][0] == 0){
                        place[0] = i;
                        place[1] = j + 1;
                        place[2] = 2;
                        return place;
                    }else if(edge[i][j][0][0] == 2 && edge[i][j][1][0] == 0 && edge[i][j][2][0] == 2 && edge[i][j][3][0] == 0){
                        place[0] = i;
                        place[1] = j + 1;
                        place[2] = 2;
                        return place;
                    }
                }
            }
        }
        return place;
    }


    public int[] findTagWithoutOneEdgeTriangle(int m, int n){
        int[] place = new int[3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (tag[i][j][0] == 0) {
                    if(edge[i][j][0][0] == 0 && edge[i][j][1][0] == 2 && edge[i][j][2][0] == 2){
                        place[0] = i;
                        place[1] = j;
                        return place;
                    }else if(edge[i][j][0][0] == 2 && edge[i][j][1][0] == 0 && edge[i][j][2][0] == 2){
                        place[0] = i + 1;
                        place[1] = j;
                        return place;
                    }else if(edge[i][j][0][0] == 2 && edge[i][j][1][0] == 2 && edge[i][j][2][0] == 0){
                        place[0] = i;
                        place[1] = j;
                        place[2] = 2;
                        return place;
                    }
                }
            }
        }
        return place;
    }



}
