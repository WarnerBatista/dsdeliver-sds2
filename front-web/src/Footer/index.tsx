import "./styles.css";
import {ReactComponent as YouTubeIcon} from "./youtube.svg";
import {ReactComponent as Linkedin} from "./linkedin.svg";
import {ReactComponent as Instragan} from "./instagram.svg";

function Footer(){
    return(
        <footer className="main-footer">
            App desenvolvido durante a 2ª ed. do evento Semana DevSuperior
            <div className="footer-icons">
                <a href="https://www.google.com.br" target="_new">
                    <YouTubeIcon />
                </a>
                <a href="https://www.google.com.br" target="_new">
                    <Linkedin />
                </a>
                <a href="https://www.google.com.br" target="_new">
                    <Instragan />
                </a>
            </div>
        </footer>
    )
}
export default Footer;