package com.iho.sn.dossiermedical.hospitalisation.service.impl;

import com.iho.sn.dossiermedical.hospitalisation.entity.TraitementMedical;
import com.iho.sn.dossiermedical.hospitalisation.repository.TraitementMedicalRepository;
import com.iho.sn.exception.EntityNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.iho.sn.entity.fixture.TraitementMedicalFixture.traitementMedical;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TraitementMedicalServiceImplTest {

    @InjectMocks
    private TraitementMedicalServiceImpl service;
    @Mock
    private TraitementMedicalRepository traitementMedicalRepository;

    @Test
    void findById_returnData() {
        TraitementMedical traitementMedical = traitementMedical();
        when(traitementMedicalRepository.findById(anyLong())).thenReturn(of(traitementMedical));

        TraitementMedical result = service.findById(1L);

        assertThat(result).isEqualTo(traitementMedical);
    }

    @Test
    void findById_throwEntityException() {

        when(traitementMedicalRepository.findById(anyLong())).thenReturn(empty());

        Assertions.assertThatThrownBy(() -> service.findById(1L))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage("Traitement not found");
    }
}