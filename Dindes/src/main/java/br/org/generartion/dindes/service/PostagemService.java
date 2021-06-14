package br.org.generartion.dindes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.org.generartion.dindes.model.Postagem;
import br.org.generartion.dindes.repository.PostagemRepository;

@Service
public class PostagemService {

	@Autowired
	private PostagemRepository postagemRepository;

	public Postagem curtir(Long id) {

		Postagem postagem = buscarPostagemPeloId(id);

		postagem.setCurtida(postagem.getCurtida() + 1);

		return postagemRepository.save(postagem);
	}

	public Postagem descurtir(Long id) {

		Postagem postagem = buscarPostagemPeloId(id);

		if (postagem.getCurtida() > 0) {

			postagem.setCurtida(postagem.getCurtida() - 1);

		}else {

			postagem.setCurtida(0);

		}

		return postagemRepository.save(postagem);

	}

	private Postagem buscarPostagemPeloId(Long id) {

		Postagem postagemSalva = postagemRepository.findById(id).orElse(null);

		if (postagemSalva == null) {

			throw new EmptyResultDataAccessException(1);
		} 

		return postagemSalva;
	}


}
