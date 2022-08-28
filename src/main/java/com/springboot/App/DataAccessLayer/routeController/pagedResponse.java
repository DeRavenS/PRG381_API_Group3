package com.springboot.App.DataAccessLayer.routeController;

import java.util.ArrayList;
import java.util.List;

public class pagedResponse<T> {
    public List<T> items = new ArrayList<T>();

    public long totalItems = 0;

    public int itemsPerPage = 0;

    public int page = 0;

    public int pageCount = 0;
}
