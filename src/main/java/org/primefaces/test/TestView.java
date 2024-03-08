package org.primefaces.test;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.primefaces.model.JpaLazyDataModel;
import org.primefaces.model.LazyDataModel;

import lombok.Data;

@Data
@Named
@ViewScoped
public class TestView implements Serializable {

    private String string;

    @Inject
    private EntityManager em;

    public List<TestJpa> getTestJpaList() {
        return testJpaList;
    }

    private List<TestJpa> testJpaList = new ArrayList<TestJpa>();

    public TestJpa getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(TestJpa selectedRow) {
        this.selectedRow = selectedRow;
    }

    private TestJpa selectedRow;


    @PostConstruct
    public void init() {
        testJpaList.add(TestJpa.builder().id(1l).stringCol("New York").numberCol(123l).decimalCol(BigDecimal.valueOf(123.45))
                .dateCol(new Date()).build());
        testJpaList.add(TestJpa.builder().id(2l).stringCol("Los Angeles").numberCol(124l).decimalCol(BigDecimal.valueOf(123.45))
                .dateCol(new Date()).build());
        testJpaList.add(TestJpa.builder().id(3l).stringCol("Hässleholm").numberCol(125l).decimalCol(BigDecimal.valueOf(123.45))
                .dateCol(new Date()).build());
    }
}
