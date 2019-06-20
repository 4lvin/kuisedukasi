package com.jongjava.alvin.kuisgame.base;

public interface MyCallback<T> {
    void onSuccess(T data);
    void onError(String message);
}

