package org.pablochitolina.exercicio.core.adapter;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BusRouteServiceImplTest {
/*
    @InjectMocks
    private LyricsServiceImpl lyricsServicePort;

    @Mock
    private BusPersistencePort busPersistencePort;

    @Mock
    private List<LyricsDto> mockLyricsDtoList;

    @Test
    public void givenLyrics_whenAdd_thenAddPortCalled() {
        final LyricsDto mockLyricsDto = mock(LyricsDto.class);

        lyricsServicePort.addLyrics(mockLyricsDto);

        verify(busPersistencePort, only()).addLyrics(mockLyricsDto);
    }

    @Test
    public void givenLyrics_whenRemove_thenRemovePortCalled() {
        final LyricsDto mockLyricsDto = mock(LyricsDto.class);

        lyricsServicePort.removeLyrics(mockLyricsDto);

        verify(busPersistencePort, only()).removeLyrics(mockLyricsDto);
    }


    @Test
    public void givenLyrics_whenUpdate_thenUpdateLyricsPortCalled() {
        final LyricsDto mockLyricsDto = mock(LyricsDto.class);

        lyricsServicePort.updateLyrics(mockLyricsDto);

        verify(busPersistencePort, only()).updateLyrics(mockLyricsDto);
    }

    @Test
    public void givenCallToAllLyrics_whenNothingSpecified_thenGetAllLyricssPortCalled() {
        when(busPersistencePort.getAllLyrics()).thenReturn(mockLyricsDtoList);

        final List<LyricsDto> allLyricsDtos = lyricsServicePort.getAllLyrics();

        assertThat(allLyricsDtos).isSameAs(mockLyricsDtoList);
        verify(busPersistencePort, only()).getAllLyrics();
    }

    @Test
    public void givenLyricsId_whenGetLyricssById_thenGetLyricsByIdPortCalled() {
        final Long testLyricsId = 1L;
        final LyricsDto mockLyricsDto = mock(LyricsDto.class);
        when(busPersistencePort.getLyricsById(testLyricsId)).thenReturn(mockLyricsDto);

        final LyricsDto lyricsDto = lyricsServicePort.getLyricsById(testLyricsId);

        assertThat(lyricsDto).isSameAs(mockLyricsDto);
        verify(busPersistencePort, only()).getLyricsById(testLyricsId);
    }
*/
}