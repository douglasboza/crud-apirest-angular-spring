import { Component, OnInit } from '@angular/core';
import { Pessoa } from '../pessoa';
import { PessoaService } from '../pessoa.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-pessoa',
  templateUrl: './create-pessoa.component.html',
  styleUrls: ['./create-pessoa.component.css']
})
export class CreatePessoaComponent implements OnInit {

  pessoa: Pessoa = new Pessoa();
  constructor(private pessoaService: PessoaService,
    private router: Router) { }

  ngOnInit(): void {
  }

  savePessoa(){
    this.pessoaService.createPessoa(this.pessoa).subscribe( data =>{
      console.log(data);
      this.goToPessoaList();
    },
    error => console.log(error));
  }

  goToPessoaList(){
    this.router.navigate(['/pessoas']);
  }
  
  onSubmit(){
    console.log(this.pessoa);
    this.savePessoa();
  }
}
