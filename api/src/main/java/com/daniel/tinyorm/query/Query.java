package com.daniel.tinyorm.query;

import java.util.List;

public interface Query<T> {

    List<T> toList();
    T toSingle();
}
