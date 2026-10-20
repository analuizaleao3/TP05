package br.unisanta.tp05.viewmodel

import androidx.lifecycle.ViewModel
import br.unisanta.tp05.dao.FilmeDao
import br.unisanta.tp05.model.Filme

class FilmeViewModel: ViewModel() {

    fun salvar(nome:String, nota:String, url:String):String{
        val filme = Filme(nome, nota.replace(",", ".").toDouble(), url)
        FilmeDao.salvar(filme)
        return "Filme salvo com sucesso!"
    }

    fun editar(posicao:Int, nome:String, nota:String, url:String):String{
        val filme = Filme(nome, nota.replace(",", ".").toDouble(), url)
        FilmeDao.editar(posicao, filme)
        return "Filme editado com sucesso!"
    }

    fun excluir(posicao:Int):String{
        FilmeDao.excluir(posicao)
        return "Filme excluído!"
    }

    fun obterFilmes():MutableList<Filme>{
        return FilmeDao.obter()
    }

    fun obterFilme(posicao:Int):Filme{
        return FilmeDao.obter()[posicao]
    }
}
