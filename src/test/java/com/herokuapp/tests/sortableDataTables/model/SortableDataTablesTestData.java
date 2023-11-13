package com.herokuapp.tests.sortableDataTables.model;

import java.util.List;

public record SortableDataTablesTestData(String header,
                                         List<String> expectedTableData) {
}
