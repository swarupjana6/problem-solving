package com.practice.designpattern.behavioral.observer.pullstyle.observers;

import com.practice.designpattern.behavioral.observer.pullstyle.Datasource;
import com.practice.designpattern.behavioral.observer.pullstyle.Observer;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SpreadSheet implements Observer {

    @NonNull
    private Datasource datasource;

    @Override
    public void update() {
        System.out.format("Spreadsheet got updated : %d\n", datasource.getValue());
    }
}
