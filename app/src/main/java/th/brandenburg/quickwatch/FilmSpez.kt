package th.brandenburg.quickwatch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FilmSpez.newInstance] factory method to
 * create an instance of this fragment.
 */
class FilmSpez : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_film_spez, container, false)
    }


    //Alle Inhalte einfügen
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? MainActivity)?.backButton?.visibility = View.VISIBLE

        val imageView: ImageView? = view.findViewById(R.id.image)
        imageView?.setImageResource(R.drawable.titel_1)

        val titleTextView: TextView? = view.findViewById(R.id.titel)
        titleTextView?.text = "Die Verurteilten"

        val directorTextView: TextView? = view.findViewById(R.id.director)
        directorTextView?.text = "directed by Frank Darabont"

        val HandlungTextView: TextView? = view.findViewById(R.id.Handlung)
        HandlungTextView?.text = "Handlung"

        val HandlungTextTextView: TextView? = view.findViewById(R.id.HandlungText)
        HandlungTextTextView?.text = "Der erfolgreiche Bankier Andy Dufresne wird fälschlicherweise wegen des Mordes an seiner Frau und ihrem Liebhaber zu lebenslanger Haft im Shawshank-Gefängnis verurteilt.\n\n" +
                "Dort freundet er sich mit dem langjährigen Insassen Ellis \"Red\" Redding an. Trotz der harten Bedingungen und der brutalen Realität des Gefängnislebens bleibt Andy optimistisch und erwirbt sich nach und nach das Vertrauen der Gefängniswärter und des Direktors durch seine Finanzkenntnisse.\n\n" +
                "Während seiner Zeit in Shawshank renoviert Andy die Gefängnisbibliothek und hilft den Insassen, ihre Abschlüsse zu machen. Im Geheimen arbeitet er jedoch an einem Fluchtplan. Nach fast zwei Jahrzehnten gelingt Andy die spektakuläre Flucht durch einen selbstgegrabenen Tunnel.\n\n" +
                "Er entlarvt die Korruption im Gefängnis und beginnt ein neues Leben in Mexiko. Am Ende wird auch Red nach jahrzehntelanger Haft entlassen und schließt sich Andy in Mexiko an, wo beide ihre Freiheit wiederfinden."

        val charTextView: TextView? = view.findViewById(R.id.Char)
        charTextView?.text = "Charaktere"

        val thumbnailImageView: ImageView? = view.findViewById(R.id.Thumbnail)
        thumbnailImageView?.setImageResource(R.drawable.shawshank)

        val recyclerView: RecyclerView = view.findViewById(R.id.CharList)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false) //<- damit der Recyclerview horizontal scrollt

        val items: MutableList<CharItem> = ArrayList()

        val Char1 = CharItem(
            "Andy Dufresne",
            "unschuldig verurteilter Bankier",
            "Andy nutzt seine Finanzkenntnisse, um das Vertrauen der Gefängnisleitung zu gewinnen und verbessert das Leben der Insassen. Er gräbt heimlich einen Tunnel und flieht.",
            R.drawable.char1
        )

        val Char2 = CharItem(
            "Ellis 'Red' Redding",
            "Langjähriger Gefängnisinsasse und Mann, der Dinge besorgen kann",
            "Red wird Andys engster Freund im Gefängnis. Nach seiner Freilassung findet er Andys versteckte Nachricht und schließt sich ihm in Mexiko an, wo beide ihre Freiheit genießen.",
            R.drawable.char2
        )

        val Char3 = CharItem(
            "Warden Samuel Norton",
            "korrupter Gefängnisdirektor",
            " Norton nutzt Andy für seine Geldwäscheoperationen. Nach Andys Flucht und Enthüllungen über die Korruption begeht Norton Selbstmord, um der Verhaftung zu entgehen.",
            R.drawable.char3
        )

        val Char4 = CharItem(
            "Captain Byron Hadley",
            "Brutaler Gefängniswärter",
            "Hadley überwacht die Insassen mit eiserner Hand. Nach Andys Flucht und den anschließenden Ermittlungen wird Hadley verhaftet.\n",
            R.drawable.char4
        )

        val Char5 = CharItem(
            "Brooks Hatlen",
            "Ältester Insasse und Bibliothekar",
            "Nach seiner Entlassung nach Jahrzehnten im Gefängnis hat Brooks Schwierigkeiten, sich an das Leben draußen anzupassen und begeht schließlich Selbstmord.",
            R.drawable.char5
        )

        items.add(Char1)
        items.add(Char2)
        items.add(Char3)
        items.add(Char4)
        items.add(Char5)

        recyclerView.adapter = CharAdapter(requireContext(), items)
        val adapter = CharAdapter(requireContext(), items)
        recyclerView.adapter = adapter

        val videoTextView: TextView? = view.findViewById(R.id.video)
        videoTextView?.text = "Video"

    }


}