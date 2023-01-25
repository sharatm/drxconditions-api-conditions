/*
 * FILE : DrxconditionsControllerTest.java
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

import static org.mockito.Mockito.when;

import com.domanirx.drxconditions.api.conditions.exceptions.RestResponseEntityExceptionHandler;
import com.domanirx.drxconditions.api.conditions.mock.MockData;
import com.rxtransaction.common.api.controller.AbstractRestControllerTest;
import com.rxtransaction.security.client.CurrentUserUtils;
import javax.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class DrxConditionsControllerTest extends AbstractRestControllerTest {

  private static final String BASE_URL = "/";
  static HttpServletRequest request;
  private final MockData mockData = new MockData();
  private AutoCloseable closeable;
  private Long defaultId = (Long) formatIdAsType(Long.class);
  // @Mock private DrxconditionsGenericService service;
  @Mock private CurrentUserUtils currentUserUtils;
  @InjectMocks private DrxConditionsController controller;

  private MockMvc mockMvc;

  @BeforeEach
  public void setup() {
    defaultId = (Long) formatIdAsType(Long.class);
    closeable = MockitoAnnotations.openMocks(this);

    // mock HttpServletRequest
    request = Mockito.mock(HttpServletRequest.class);
    // mock the returned value of request.getHeaderNames()
    when(request.getHeader("masterCustomerSetId")).thenReturn("12");
    when(request.getHeader("platform")).thenReturn("DR2");

    mockMvc =
        MockMvcBuilders.standaloneSetup(controller)
            .setControllerAdvice(new RestResponseEntityExceptionHandler())
            .build();
  }

  @AfterEach
  void closeService() throws Exception {
    closeable.close();
  }

  /*@Test
  void testListDrxconditionss() throws Exception {
    // given
    List<DrxconditionsDTO> customerSpecifics = new ArrayList<>();
    customerSpecifics.add(new DrxconditionsDTO());
    customerSpecifics.add(new DrxconditionsDTO());

    when(service.getAll()).thenReturn(customerSpecifics);

    // when
    mockMvc
        .perform(
            get(BASE_URL).contentType(MediaType.APPLICATION_JSON).header("masterCustomerSetId", 1L))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data.*", hasSize(2)));
    verify(service, times(1)).getAll();
  }

  @Test
  void testGetById() throws Exception {
    // given
    DrxconditionsDTO dto = mockData.mockDrxconditionsDTO();
    dto.setDrxconditionsId(getDefaultId());

    when(service.getById(getDefaultId())).thenReturn(dto);

    // when
    mockMvc
        .perform(
            get(BASE_URL + dto.getDrxconditionsId())
                .contentType(MediaType.APPLICATION_JSON)
                .header("masterCustomerSetId", 1L))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data.activeInd", equalTo(true)));
    verify(service, times(1)).getById(dto.getDrxconditionsId());
  }

  @Test
  void testAddDrxconditions() throws Exception {
    // given
    DrxconditionsDTO requestDto = mockData.mockDrxconditionsDTO();
    DrxconditionsDTO dto = mockData.mockDrxconditionsDTO();
    dto.setDrxconditionsId(getDefaultId());

    when(service.add(any(DrxconditionsDTO.class))).thenReturn(dto);
    // when
    mockMvc
        .perform(
            post(BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .header("masterCustomerSetId", 1L)
                .content(asJsonString(requestDto)))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.data.drxconditionsId", equalTo(1)));
    // .andExpect(jsonPath("$.data.name", equalTo("Drxconditions1")))
    // .andExpect(jsonPath("$.data.abaNumber", equalTo("123456789")))
    verify(service, times(1)).add(any(DrxconditionsDTO.class));
  }

  @Test
  void testUpdate() throws Exception {
    // given
    Long defaultId = getDefaultId();
    DrxconditionsDTO requestDto = mockData.mockDrxconditionsDTO();
    requestDto.setDrxconditionsId(defaultId);
    DrxconditionsDTO dto = mockData.mockDrxconditionsDTO();
    dto.setDrxconditionsId(defaultId);

    when(service.update(defaultId, requestDto)).thenReturn(dto);

    // when
    mockMvc
        .perform(
            put(BASE_URL + dto.getDrxconditionsId())
                .contentType(MediaType.APPLICATION_JSON)
                .header("masterCustomerSetId", 1L)
                .content(asJsonString(requestDto)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data.drxconditionsId", equalTo(1)));
    // .andExpect(jsonPath("$.data.name", equalTo("Drxconditions1")))
    // .andExpect(jsonPath("$.data.abaNumber", equalTo("123456789")));
    verify(service, times(1)).update(defaultId, requestDto);
  }

  @Test
  void testGetBySearchCriteria() throws Exception {

    List<DrxconditionsDTO> list = new ArrayList<>();
    list.add(new DrxconditionsDTO());
    PageRequest pageRequest = PageRequest.of(0, 10);
    Page<DrxconditionsDTO> page = new PageImpl<>(list, pageRequest, 1);
    when(service.getPageBySearchCriteria(any(DrxconditionsSearchDTO.class), any(PageRequest.class)))
        .thenReturn(page);

    Pagination pagination = new Pagination();
    DrxconditionsSearchDTO searchRequest = new DrxconditionsSearchDTO();
    searchRequest.setActiveInd(true);
    searchRequest.setPagination(pagination);

    mockMvc
        .perform(
            post(BASE_URL + "search")
                .contentType(MediaType.APPLICATION_JSON)
                .header("masterCustomerSetId", 1L)
                .content(asJsonString(searchRequest)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data.*", hasSize(1)));

    verify(service, times(1))
        .getPageBySearchCriteria(any(DrxconditionsSearchDTO.class), any(Pageable.class));
  }

  @Test
  void testDeleteDrxconditionsById() throws Exception {
    // given
    when(service.deleteById(any(Long.class))).thenReturn(true);

    mockMvc
        .perform(
            delete(BASE_URL + getDefaultId())
                .contentType(MediaType.APPLICATION_JSON)
                .header("masterCustomerSetId", 1L))
        .andExpect(status().isOk());
    verify(service, times(1)).deleteById(getDefaultId());
  }

  @Test
  void testNotFoundException() throws Exception {
    when(service.getById(any(Long.class)))
        .thenThrow(new NoResultsFoundException("No results found for customerspecific 1"));

    mockMvc
        .perform(
            get(BASE_URL + getDefaultId())
                .contentType(MediaType.APPLICATION_JSON)
                .header("masterCustomerSetId", 1L))
        .andExpect(status().isNotFound())
        .andExpect(jsonPath("$.message", equalTo("No results found for customerspecific 1")));
    verify(service, times(1)).getById(getDefaultId());
  }

  @Test
  void testFindNotFoundException() throws Exception {
    Long id = getDefaultId();
    when(service.getById(id)).thenThrow(new NoResultsFoundException("no results"));

    NoResultsFoundException exception =
        assertThrows(
            NoResultsFoundException.class,
            () -> {
              controller.getDrxconditionsById(id);
            });

    verify(service, times(1)).getById(id);
    assertNotNull(exception);
  }

  @Test
  void testDeleteNotFoundException() throws Exception {
    Long id = getDefaultId();
    when(service.deleteById(id)).thenReturn(false);

    NoResultsFoundException exception =
        assertThrows(
            NoResultsFoundException.class,
            () -> {
              controller.deleteDrxconditionsById(id);
            });

    verify(service, times(1)).deleteById(id);
    verify(service, times(0)).getById(id);
    assertNotNull(exception);
  }

  @Test
  void testUpdateNotFoundException() throws Exception {
    Long id = getDefaultId();
    DrxconditionsDTO dto = mockData.mockDrxconditionsDTO();
    dto.setDrxconditionsId(id);

    when(service.update(id, dto)).thenThrow(new NoResultsFoundException("non found"));

    NoResultsFoundException exception =
        assertThrows(
            NoResultsFoundException.class,
            () -> {
              controller.updateDrxconditions(dto, id);
            });

    verify(service, times(1)).update(id, dto);
    verify(service, times(0)).getById(id);
    assertNotNull(exception);
  }*/

  protected Long getDefaultId() {
    return defaultId;
  }

  private Object formatIdAsType(Class<?> expectedTypeClass) {

    Long defaultId = 1L;
    if (expectedTypeClass.isAssignableFrom(defaultId.getClass())) {
      return defaultId;
    }

    String defaultIdAsStr = defaultId.toString();
    if (expectedTypeClass.isAssignableFrom(defaultIdAsStr.getClass())) {
      return defaultIdAsStr;
    }
    throw new UnsupportedOperationException(
        "getDefaultId requires an implementation for id-type:" + Long.class.getSimpleName());
  }
}
