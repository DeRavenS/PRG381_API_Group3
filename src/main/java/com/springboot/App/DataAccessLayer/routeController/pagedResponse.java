package com.springboot.App.DataAccessLayer.routeController;

import java.util.*;

public class pagedResponse<T> {
    public List<T> items = new ArrayList<T>();

    public int totalItems = 0;

    public int itemsPerPage = 0;
}
