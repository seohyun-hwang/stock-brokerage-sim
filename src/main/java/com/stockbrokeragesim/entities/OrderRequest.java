package com.stockbrokeragesim.entities;

import java.util.ArrayList;

public class OrderRequest {
    private String ticker;
    private short shareInteractionType;
    // xx1: market order; xx2: limit order; xx3: stop-loss order; xx4: stop-limit order; xx5: trailing-stop order
    // x1x: buy action; x2x: sell action; x3x: short action; x4x: buy-to-cover action
    // 1xx: good-til-canceled order; 2xx: day order: 3xx: already possessed (not an order)

    private double price;
    private int quantity;

    public Object getQuantity() {
    }

    public double getPrice() {
    }

    public String getAction() {
    }
}
