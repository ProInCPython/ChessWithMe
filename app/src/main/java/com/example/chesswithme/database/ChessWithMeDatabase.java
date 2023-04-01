package com.example.chesswithme.database;

import java.util.List;

public interface ChessWithMeDatabase {
    void save(User user);

    User get(int password);

    List<User> getAll();
}
