package services.Order;

import utils.hibernate.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        SetWeightAndVolume setWeightAndVolume = new SetWeightAndVolume();
        setWeightAndVolume.setMaxWeightAndVolume("5", new HibernateUtil().getSessionFactory());
    }
}
