#include <iostream>
#include <vector>
#include <queue>
#include <cmath>
#include <algorithm>
#include <limits>

using namespace std;

const int ROWS = 15;
const int COLS = 15;

struct Node {
    int r, c;
    int pr, pc;
    double g, h, f; 

    Node(int row = 0, int col = 0) {
        r = row;
        c = col;
        pr = -1;
        pc = -1;
        g = numeric_limits<double>::max();
        h = 0.0;
        f = numeric_limits<double>::max();
    }

    void calcF() {
        f = g + h;
    }
};

struct CmpNode {
    bool operator()(const Node* a, const Node* b) const {
        return a->f > b->f;
    }
};

bool isValid(int r, int c) {
    return (r >= 0) && (r < ROWS) && (c >= 0) && (c < COLS);
}

double heuristic(int r1, int c1, int r2, int c2) {
    return abs(r1 - r2) + abs(c1 - c2);
}

void tracePath(const vector<vector<Node>>& nodes, int er, int ec, vector<vector<char>>& dispGrid) {
    Node curr = nodes[er][ec];
    while (curr.pr != -1 && curr.pc != -1) {
        if (dispGrid[curr.r][curr.c] != 'S' && dispGrid[curr.r][curr.c] != 'E') {
             dispGrid[curr.r][curr.c] = '*';
        }
        curr = nodes[curr.pr][curr.pc];
    }
}

void aStar(vector<vector<int>>& grid, int sr, int sc, int er, int ec) {
    if (!isValid(sr, sc) || !isValid(er, ec)) {
        cout << "Error: Invalid start/end." << endl;
        return;
    }

    if (grid[sr][sc] == 1 || grid[er][ec] == 1) {
        cout << "Error: Start/End is on a wall." << endl;
        return;
    }

    vector<vector<Node>> nodes(ROWS, vector<Node>(COLS));
    for (int r = 0; r < ROWS; ++r) {
        for (int c = 0; c < COLS; ++c) {
            nodes[r][c] = Node(r, c);
        }
    }

    nodes[sr][sc].g = 0.0;
    nodes[sr][sc].h = heuristic(sr, sc, er, ec);
    nodes[sr][sc].calcF();

    priority_queue<Node*, vector<Node*>, CmpNode> pq;
    pq.push(&nodes[sr][sc]);

    vector<vector<bool>> closed(ROWS, vector<bool>(COLS, false));
    bool found = false;

    while (!pq.empty()) {
        Node* curr = pq.top();
        pq.pop();

        int r = curr->r;
        int c = curr->c;

        if (closed[r][c]) {
            continue;
        }
        closed[r][c] = true;

        if (r == er && c == ec) {
            found = true;
            break;
        }

        int dr[] = {-1, 1, 0, 0};
        int dc[] = {0, 0, 1, -1};

        for(int i = 0; i < 4; ++i) {
            int nr = r + dr[i];
            int nc = c + dc[i];
        
            if (isValid(nr, nc) && grid[nr][nc] == 0 && !closed[nr][nc]) {
                double newG = curr->g + 1.0;

                if (newG < nodes[nr][nc].g) {
                    nodes[nr][nc].pr = r;
                    nodes[nr][nc].pc = c;
                    nodes[nr][nc].g = newG;
                    nodes[nr][nc].h = heuristic(nr, nc, er, ec);
                    nodes[nr][nc].calcF();
                    pq.push(&nodes[nr][nc]);
                }
            }
        }
    }

    cout << "\nResult:" << endl;
    vector<vector<char>> dispGrid(ROWS, vector<char>(COLS, '.'));
    for (int r = 0; r < ROWS; ++r) {
        for (int c = 0; c < COLS; ++c) {
            if (grid[r][c] == 1) {
                dispGrid[r][c] = '#';
            }
        }
    }
    dispGrid[sr][sc] = 'S';
    dispGrid[er][ec] = 'E';

    if (found) {
        cout << "Path found." << endl;
        tracePath(nodes, er, ec, dispGrid);
    } else {
        cout << "No path found." << endl;
    }

    for (int r = 0; r < ROWS; ++r) {
        for (int c = 0; c < COLS; ++c) {
            cout << dispGrid[r][c] << ' ';
        }
        cout << endl;
    }
}

void printGrid(const vector<vector<int>>& grid, int sr, int sc, int er, int ec) {
    for (int r = 0; r < ROWS; ++r) {
        for (int c = 0; c < COLS; ++c) {
            if (r == sr && c == sc) {
                cout << "S ";
            } else if (r == er && c == ec) {
                cout << "E ";
            } else if (grid[r][c] == 1) {
                cout << "# ";
            } else {
                cout << ". ";
            }
        }
        cout << endl;
    }
}

int main() {
    vector<vector<int>> grid(ROWS, vector<int>(COLS, 0));
    int sr = -1, sc = -1;
    int er = -1, ec = -1;
    int wr, wc;

    cout << "A* Pathfinding Setup" << endl;
    cout << "Grid: " << ROWS << "x" << COLS << ", Coords are 0-indexed." << endl;

    while (true) {
        cout << "Start (row col): ";
        cin >> sr >> sc;
        if (isValid(sr, sc)) break;
        cout << "Invalid. Next." << endl;
    }

    while (true) {
        cout << "End (row col): ";
        cin >> er >> ec;
        if (isValid(er, ec)) break;
        cout << "Invalid. Next." << endl;
    }

    cout << "\nWalls (-1 -1 to finish):" << endl;
    while (true) {
        cout << "\nCurrent Grid:" << endl;
        printGrid(grid, sr, sc, er, ec);
        
        cout << "Wall (row col): ";
        cin >> wr >> wc;

        if (wr == -1 && wc == -1) break;

        if (isValid(wr, wc)) {
            if ((wr == sr && wc == sc) || (wr == er && wc == ec)) {
                cout << "Error: Can't place on S/E." << endl;
            } else {
                grid[wr][wc] = 1;
            }
        } else {
            cout << "Invalid. Next." << endl;
        }
    }
    
    aStar(grid, sr, sc, er, ec);

    return 0;
}
