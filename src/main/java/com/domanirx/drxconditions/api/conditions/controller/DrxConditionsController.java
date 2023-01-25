/*
 * FILE : DrxconditionsController.java
 *
 * COPYRIGHT:
 *
 * The computer systems, procedures, data bases and programs created and maintained by SS&C Health,
 * are proprietary in nature and as such are confidential. Any unauthorized use or disclosure of
 * such information may result in civil liabilities.
 *
 * Copyright (C) 2021- by SS&C Health. All Rights Reserved.
 *
 */
package com.domanirx.drxconditions.api.conditions.controller;

import com.rxtransaction.common.api.controller.BaseController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
// @PreAuthorize("hasAuthority('ROLE_APP_DRXCONDITIONS')")
public class DrxConditionsController extends BaseController {

  private static final String NO_RESULTS_STR = "No results found for drxconditions ";
  // private final DrxconditionsGenericService genericService;

  // Used to return a list of drxconditionss.
  // @SuppressWarnings("rawtypes")
  /*@Override
  public ResponseEntity<ResponseData> getAllDrxconditionss() throws Exception {
    log.info("Retrieving all customerspecifics");
    List<DrxconditionsDTO> drxconditionss = genericService.getAll();
    return new ResponseEntity<>(ResponseData.success(drxconditionss), HttpStatus.OK);
  }

  // returns a single drxconditions by drxconditionsId
  @SuppressWarnings("rawtypes")
  @Override
  public ResponseEntity<ResponseData> getDrxconditionsById(@NotNull Long drxconditionsId)
      throws Exception {
    log.info("Retrieving drxconditions {}", drxconditionsId);
    DrxconditionsDTO moduleDto = genericService.getById(drxconditionsId);
    return new ResponseEntity<>(ResponseData.success(moduleDto), HttpStatus.OK);
  }

  @SuppressWarnings("rawtypes")
  @Override
  public ResponseEntity<ResponseData> addDrxconditions(@Valid DrxconditionsDTO body)
      throws Exception {
    log.info("Creating drxconditions");
    return new ResponseEntity<>(ResponseData.success(genericService.add(body)), HttpStatus.CREATED);
  }

  @SuppressWarnings("rawtypes")
  @Override
  public ResponseEntity<ResponseData> updateDrxconditions(
      @Valid DrxconditionsDTO body, @NotNull Long drxconditionsId) throws Exception {
    log.info("Updating drxconditions {}", drxconditionsId);
    return new ResponseEntity<>(
        ResponseData.success(genericService.update(drxconditionsId, body)), HttpStatus.OK);
  }

  @SuppressWarnings("rawtypes")
  @Override
  public ResponseEntity<ResponseData> deleteDrxconditionsById(@NotNull Long drxconditionsId)
      throws Exception {
    log.info("Deactivating drxconditions {}", drxconditionsId);
    // technically could be null so do False.equals check
    if (Boolean.FALSE.equals(genericService.deleteById(drxconditionsId))) {
      log.warn("No results found for drxconditions {}", drxconditionsId);
      throw new NoResultsFoundException(NO_RESULTS_STR + drxconditionsId);
    }
    return new ResponseEntity<>(ResponseData.success(null), HttpStatus.OK);
  }

  @SuppressWarnings("rawtypes")
  @Override
  public ResponseEntity<SearchResponse> getDrxconditionsBySearchCriteria(
      @Valid DrxconditionsSearchDTO body) throws Exception {
    log.info("Searching drxconditionss");

    Page<DrxconditionsDTO> dtoPage =
        genericService.getPageBySearchCriteria(
            body, PaginationUtil.getPageable(body.getPagination()));
    return new ResponseEntity<>(
        SearchResponse.success(dtoPage.getContent(), dtoPage.getTotalElements()), HttpStatus.OK);
  }*/
}
