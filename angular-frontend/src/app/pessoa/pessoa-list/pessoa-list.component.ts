import { Component, OnInit } from '@angular/core';
import { Pessoa } from '../../pessoa'
import { PessoaService } from '../../pessoa.service'
import { Router } from '@angular/router';
@Component({
  selector: 'app-pessoa-list',
  templateUrl: './pessoa-list.component.html',
  styleUrls: ['./pessoa-list.component.css']
})
export class PessoaListComponent implements OnInit {

  pessoas: Pessoa[];

  constructor(public pessoaService: PessoaService,
    public router: Router) { }

  ngOnInit(): void {
    this.getPessoas();
  }

  public getPessoas(){
    this.pessoaService.getPessoasList().subscribe(data => {
      this.pessoas = data;
    });
  }

  pessoaDetails(id: number){
    this.router.navigate(['pessoa-details', id]);
  }

  updatePessoa(id: number){
    this.router.navigate(['update-pessoa', id]);
  }

  deletePessoa(id: number){
    this.pessoaService.deletePessoa(id).subscribe( data => {
      console.log(data);
      this.getPessoas();
    })
  }
}
