package com.springboot.Repository;

import org.springframework.data.repository.CrudRepository;


import com.springboot.Entity.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer> {

}
