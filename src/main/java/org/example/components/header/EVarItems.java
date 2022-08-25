package org.example.components.header;

public enum EVarItems {
    CATEGORY("Categorias"),
    SALES("Ofertas"),
    HISTORY("Historial"),
    SUPERMARKET("Supermercado"),
    FASHION("Moda"),
    SALE("Vender"),
    HELP("Ayuda");

    private String text;

    EVarItems(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }
}
