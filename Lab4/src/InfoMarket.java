public class InfoMarket {
    private Market[] market;

    public InfoMarket(Market market) {
    }

    public InfoMarket(Market[] market) {
        this.market = market;
    }

    public int[] getInfoNumberOfSellingProducts(String salesman) {
        int N = 0;
        int quantity = 0;
        for (int i = 0; i < market.length; i++) {
            if (market[i].getSalesman().equals(salesman)) {
                quantity += market[i].getQuantity();
                N++;
            }
        }
        int[] arr = {quantity, N};
        return arr;
    }

    public int[] getSoldProducts(String salesman) {
        int[] arr = new int[getInfoNumberOfSellingProducts(salesman)[1]];
        for (int i=0; i<arr.length; i++)
        {
            for (int j=0; j< market.length; j++)
            {
                if (market[j].getSalesman().equals(salesman))
                {
                    arr[i] = j; i++;

                }
            }
        }
        return arr;

    }

    public String getExpensiveProd(String salesman) {
        int[] arr = getSoldProducts(salesman);
        int max_index = arr[0];
        for (int i = 0; i < arr.length-1; i++)
                 if (market[max_index].getPrice() < market[arr[i+1]].getPrice()) {
                    max_index = arr[i+1];
                 }
        String str = "Продал: " + market[max_index].getSalesman() + ". Товар: " + market[max_index].getName_product() + ". Штук: " + market[max_index].getQuantity() + ". Цена: " + market[max_index].getPrice() + ". Дата продажи " + market[max_index].getDate_seller();
        return str;
    }

    public String[] getInfoProd(String salesman) {
       int [] arr = getSoldProducts(salesman);
        String[] strArr = new String[arr.length];
        for (int j = 0; j < arr.length; j++) {
            int index = arr[j];

            strArr[j] = "\nПродал: " + market[index].getSalesman() + ". Товар: " + market[index].getName_product() + ". Штук: " + market[index].getQuantity() + ". Цена: " + market[index].getPrice() + ". Дата продажи " + market[index].getDate_seller();
        }
        return strArr;
    }
}

