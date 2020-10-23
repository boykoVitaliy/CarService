package ua.com.carservice.constants;

import ua.com.carservice.service.serviceImpl.CarServiceImpl;
import ua.com.carservice.service.serviceImpl.GoodsServiceImpl;

public final class Errors {

//    CarServiceImpl
    public static final String NOT_FOUND_YEAR="The cars has not been found since that year:";
    public static final String FIELD_USERID_IS_EMPTY="Pleas Enter user Id";
    public static final String NOT_FOUND_INFO="Not found information";

//    GoodsServiceImpl
    public static final String FIELD_PRICE_IS_EMPTY="Pleas enter price";
    public static final String NOT_FOUND_GOODS="No goods with this price was found";

}