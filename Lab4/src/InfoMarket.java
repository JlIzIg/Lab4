public class InfoMarket {
    private Market[] market;
    

    public Market[] getMarket() {
        return market;
    }

    public void setMarket(Market[] market) {
        this.market = market;
    }

    public InfoMarket() {
    }

    public InfoMarket(Market[] market) {
        this.market = market;
   
    }

    public int[] getInfoNumberOfSellingProducts( String salesman) {
        int N = 0;
        int quantity = 0;
        for (int i = 0; i < markets.length; i++) {
            if (markets[i].getSalesman().equals(salesman)) {
                quantity += markets[i].getQuantity();
                N++;
            }
        }
        int[] arr = {quantity, N};
        return arr;
    }

    public static Market[] getArraySoldProducts(Market[] markets, String salesman) {
        int[] arr = getInfoNumberOfSellingProducts(markets, salesman);
        int N = arr[1];
        Market[] markets1 = new Market[N];
        for (int i = 0; i < markets.length; i++)
            for (int j = 0; j < N; j++) {
                if (markets[i].getSalesman().equals(salesman)) {
                    markets1[j] = new Market(markets[i].getSalesman(), markets[i].getName_product(), markets[i].getQuantity(), markets[i].getPrice(), markets[i].getDate_seller());
                }
            }
        return markets1;
    }

    public static Market getHighestPrice(Market[] markets) {
        int max_index = 0;
        for (int i = 0; i < markets.length - 1; i++) {
            if (markets[max_index].getPrice() < markets[i + 1].getPrice()) max_index = i + 1;
        }
        return markets[max_index];
    }
}

