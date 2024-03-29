public class GoldMiner {
    int[][] g;
    boolean[][] vis;
    int m, n;
    public int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int getMaximumGold(int[][] grid) {
        g = grid;
        m = g.length; n = g[0].length;
        vis = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] != 0) {
                    vis[i][j] = true;
                    ans = Math.max(ans, dfs(i, j));
                    vis[i][j] = false;
                }
            }
        }
        return ans;
    }

    int dfs(int x, int y) {
        int ans = g[x][y];
        for (int[] d : dirs) {
            int nx = x + d[0], ny = y + d[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if (g[nx][ny] == 0) continue;
            if (vis[nx][ny]) continue;
            vis[nx][ny] = true;
            ans = Math.max(ans, g[x][y] + dfs(nx, ny));
            vis[nx][ny] = false;
        }
        return ans;
    }

    public static void  main(String[] args)
    {
        GoldMiner s = new GoldMiner();
        int[][] g = new int[][]{{0,6,0}, {5,8,7},{0,9,0}};
        int i = s.getMaximumGold(g);
        System.out.println(i);
    }
}