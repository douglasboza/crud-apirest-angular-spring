import { Component, OnInit } from '@angular/core';
import { Medico } from '../../medico';
import { Pessoa } from '../../pessoa';
import { MedicoService } from '../../medico.service';
import { PessoaService } from '../../pessoa.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-medico',
  templateUrl: './create-medico.component.html',
  styleUrls: ['./create-medico.component.css']
})
export class CreateMedicoComponent implements OnInit {

  medico: Medico = new Medico();
  pessoas: Pessoa[];

  constructor(public medicoService: MedicoService, public pessoaService: PessoaService,
    public router: Router) { }

  ngOnInit(): void {
    this.getPessoas();
  }

  public getPessoas(){
    this.pessoaService.getPessoasList().subscribe(data => {
      this.pessoas = data;
    });
  }

  saveMedico(){
    this.medicoService.createMedico(this.medico).subscribe( data =>{
      console.log(data);
      this.goToMedicoList();
    },
    error => console.log(error));
  }

  goToMedicoList(){
    this.router.navigate(['/medicos']);
  }
  
  onSubmit(){
    console.log(this.medico);
    this.saveMedico();
  }
}
