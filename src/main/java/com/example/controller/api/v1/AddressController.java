package com.example.controller.api.v1;

import com.example.dto.AddressDto;
import com.example.model.Address;
import com.example.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.example.controller.api.v1.ApiV1BaseControler.BASE_URL;

@RestController
@RequestMapping(BASE_URL + "/addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    /**
     * GET: /api/v1/addresses?userId=:userId
     *
     * @param userId
     * @param pageable
     * @return
     */
    @GetMapping
    public Page<Address> index(@RequestParam Long userId, @PageableDefault Pageable pageable) {
        return addressService.findAllByUserIdOrderByFavoriteDescUpdatedAtDesc(userId, pageable);
    }

    /**
     * POST: /api/v1/addresses?userId=:userId
     *
     * @param userId
     * @param addressDto
     * @return
     */
    @PostMapping
    public Address create(@RequestParam Long userId, @RequestBody AddressDto addressDto) {
        return addressService.create(addressDto, userId);
    }

    /**
     * DELETE: /api/v1/addresses/:addressId
     *
     * @param addressId
     */
    @DeleteMapping("/{addressId}")
    public void delete(@PathVariable Long addressId) {
        addressService.delete(addressId);
    }
}
