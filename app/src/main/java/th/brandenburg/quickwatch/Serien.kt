package th.brandenburg.quickwatch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Serien.newInstance] factory method to
 * create an instance of this fragment.
 */
class Serien : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_filme, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.film_recycler_view)

        val items: MutableList<Item> = ArrayList()
        items.add(Item("Die Serie von dein einen Typen", "Ach der wieder jaja", R.drawable.title_2))
        items.add(Item("Noch mehr Text", "Bilbo Freud", R.drawable.title_2))
        items.add(Item("Noch nicht geshen", "Ein Name", R.drawable.title_2))
        items.add(Item("Beispielo der Dritte", "Blablabla", R.drawable.title_2))


        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = MyAdapter(requireContext(), items)

    }

}