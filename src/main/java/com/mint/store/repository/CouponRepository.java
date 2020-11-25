package com.mint.store.repository;

import com.mint.store.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * @author MintsBerry
 * @date 2020/11/25
 */
public interface CouponRepository extends JpaRepository<Coupon, Long> {
  @Query("select c from Coupon c\n" +
          "join c.categoryList ca\n" +
          "join " +
          "Activity a on a.id = c.activityId\n" +
          "where ca.id = :cid\n" +
          "and a.startTime < :now\n" +
          "and a.endTime > :now\n")
  List<Coupon> selByCategory(Long cid, Date now);


  @Query("select c from Coupon c\n" +
          "join Activity a on a.id = c.activityId\n" +
          "where c.wholeStore = :isWholeStore\n" +
          "and a.startTime < :now\n" +
          "and a.endTime > :now")
  List<Coupon> selByWholeStore(boolean isWholeStore, Date now);

  @Query("select c from Coupon c \n" +
          "join UserCoupon uc\n" +
          "on c.id = uc.couponId\n" +
          "join User u\n" +
          "on u.id = uc.userId\n" +
          "where uc.status = 1\n" +
          "and u.id = :uid\n" +
          "and c.startTime < :now\n" +
          "and c.endTime > :now\n" +
          "and uc.orderId is null")
  List<Coupon> findMyAvailable(Long uid, Date now);

  @Query("select c from Coupon c \n" +
          "join UserCoupon uc\n" +
          "on c.id = uc.couponId\n" +
          "join User u\n" +
          "on u.id = uc.userId\n" +
          "where uc.status = 2\n" +
          "and u.id = :uid\n" +
          "and c.startTime < :now\n" +
          "and c.endTime > :now\n" +
          "and uc.orderId is not null")
  List<Coupon> findUsed(Long uid, Date now);

  @Query("select c from Coupon c \n" +
          "join UserCoupon uc\n" +
          "on c.id = uc.couponId\n" +
          "join User u\n" +
          "on u.id = uc.userId\n" +
          "where uc.status <> 2\n" +
          "and u.id = :uid\n"  +
          "and c.endTime < :now\n" +
          "and uc.orderId is null")
  List<Coupon> findExpired(Long uid, Date now);
}
